package com.dh.creditcard.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.creditcard.model.GetCreditCardRequest;

@Component
public class GetCreditCardDetailsRoute extends RouteBuilder{

	@Override
	public void configure() {
		
		restConfiguration()
		.bindingMode(RestBindingMode.json);
		rest()
		.post("api/v1/GetDetails")
		.type(GetCreditCardRequest.class)
		.consumes("application/json")
		.to("direct:getDetails");
		
		onException(Exception.class)
		.log("inside exception")
		.to("bean:utils?method=onException(${exchange},\"CreditCardResponse\",\"MW\")")
		.log("Exception"+"${exception}").handled(true)
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500));
		
		from("direct:getDetails").routeId("getDetails")
		
		.to("bean:creditCardService?method=prepareCreditCardRequest")
		
//		.marshal().json(JsonLibrary.Jackson)
		.marshal(new JacksonDataFormat(GetCreditCardRequest.class))
		
		.choice()
		.when().jsonpath("$.CreditCardDetailsRequest[?(@.cardNumber != 0 && @.cardNumber != '' && @.cardType != null && @.cardType != '')]")
			
			.to("{{creditCardMock.host}}{{creditCardMock.contextPath}}GetDetails?bridgeEndpoint=true")
//			.to("{{CreditCard.host}}{{CreditCard.contextPath}}getdetails?bridgeEndpoint=true")
			.choice()
				.when().simple("${body} != null")
					.to("bean:creditCardService?method=prepareCreditCardResponse")
				.otherwise()
					.to("bean:utils?method=prepareFaultNodeStr(\"CreditCardResponse\",\"RECORDNOTFOUND\",\"\",\"\",\"\",\"sysOrAppWithoutBkndError\",${exchange})")
				.endChoice()
		.otherwise()
				.to("bean:utils?method=prepareFaultNodeStr(\"CreditCardResponse\",\"MANDATORYVALUE\",\"\",\"\",\"\",\"validations\",${exchange})")
		.end();

	}
}

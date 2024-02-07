package com.dh.creditcard.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.creditcard.model.NewCreditCardRequest;

@Component
public class NewCreditCardRouteBuilder extends RouteBuilder{

	@Override
	public void configure() {
		

		restConfiguration()
		.bindingMode(RestBindingMode.json);
		rest()
		.post("/v1/newcreditcard")
		.type(NewCreditCardRequest.class)
		.consumes("application/json")
		.to("direct:NewCreditCard");
		
		onException(Exception.class)
		.log("inside exception")
		.to("bean:utils?method=onException(${exchange},\"NewCreditCardResponse\",\"MW\")")
		.log("Exception"+"${exception}").handled(true)
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500));
		
		from("direct:NewCreditCard")
		.to("bean:newCreditCardService?method=prepareNewCreditCardRequest")
		
		.marshal().json(JsonLibrary.Jackson)
		
		.choice()
			.when().jsonpath("$.NewCreditCardRequest.NewCustomer[?(@.accNo != 0 && @.name != null && @.phoneNumber != null && @.CardDetails.cibilScore != 0 && @.CardDetails.salary != 0)]")
					.to("http://localhost:8082/newcreditcard?bridgeEndpoint=true")
					.to("bean:newCreditCardService?method=prepareNewCreditCardResponse")
		.otherwise()
					.to("bean:utils?method=prepareFaultNodeStr(${body},\"NewCreditCardResponse\",${exchange})")
		.end();
	}
}

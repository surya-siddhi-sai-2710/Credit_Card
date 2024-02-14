package com.dh.creditcard;


import org.apache.camel.CamelContext;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.AdviceWith;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.apache.camel.component.mock.MockEndpoint;

import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpointsAndSkip;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dh.creditcard.model.GetCreditCardRequest;
import com.dh.creditcard.model.GetCreditCardResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@UseAdviceWith
@CamelSpringBootTest
@SpringBootApplication
@WebAppConfiguration

@MockEndpointsAndSkip("{{configStoreConnector.host}}{{configStoreConnector.contextPath}} | {{creditCardMock.host}}{{creditCardMock.contextPath}}GetDetails?bridgeEndpoint=true")

@ImportResource({ "classpath:spring/camel-context.xml" })
@PropertySource("classpath:application-test.properties")
@Configuration
@ComponentScan("com.dh.creditcard.*")
public class GetCreditCardRouteTest {

	@Autowired
	CamelContext camelContext;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ProducerTemplate producerTemplate;

//	@EndpointInject("mock://{{CreditCard.host}}{{CreditCard.contextPath}}getdetails?bridgeEndpoint=true")
	@EndpointInject("mock:{{creditCardMock.host}}{{creditCardMock.contextPath}}GetDetails?bridgeEndpoint=true")
	private MockEndpoint cdmockEndpoint;
	
	@EndpointInject("mock://{{configStoreConnector.host}}{{configStoreConnector.contextPath}}")
    private MockEndpoint configStore;
	
	@Test
	public void getCreditCardDetailsSuccessTest() throws Exception {

		String getDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/GetCreditCardDetails/SuccessRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore  = Resources.toString(
				Resources.getResource("mock/frontend/configStore/ConfigStoreResponse_Application_Errors.json"), Charsets.UTF_8);
		
		String getDetailsRespose = Resources.toString(
				Resources.getResource("mock/backend/GetCreditCardDetails/SuccessResponse.json"),
				Charsets.UTF_8);
		
		AdviceWith.adviceWith(camelContext,"getDetails",routeBuilder->

		{
			routeBuilder.replaceFromWith("direct:getDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getDetailsRespose);
			}
		});
		
		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();
		
		GetCreditCardRequest oGetCreditCardRequest = objectMapper.readValue(getDetailsRequest, GetCreditCardRequest.class);
		
		GetCreditCardResponse successResponse = producerTemplate.requestBody("direct:getDetails", oGetCreditCardRequest, GetCreditCardResponse.class);
	
		System.out.println(successResponse.toString());
		
		Assertions.assertNotNull(successResponse.getCreditCardDetails().getCustomerDetails().getAccNo());
		
	 
	}
	
	@Test
	public void getCreditCardDetailsFaultTest() throws Exception {
		
		String getDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/GetCreditCardDetails/FaultRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore  = Resources.toString(
				Resources.getResource("mock/frontend/configStore/ConfigStoreResponse_Application_Errors.json"), Charsets.UTF_8);
		
		String getDetailsRespose = Resources.toString(
				Resources.getResource("mock/backend/GetCreditCardDetails/FaultResponse.json"),
				Charsets.UTF_8);
		
		AdviceWith.adviceWith(camelContext,"getDetails",routeBuilder->

		{
			routeBuilder.replaceFromWith("direct:getDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getDetailsRespose);
			}
		});
		
		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();
		
		GetCreditCardRequest oGetCreditCardRequest = objectMapper.readValue(getDetailsRequest, GetCreditCardRequest.class);
		
		String faultResponse = producerTemplate.requestBody("direct:getDetails", oGetCreditCardRequest, String.class);
	
		System.out.println("Fault response: " + faultResponse);
		
		Assertions.assertTrue(faultResponse.contains("Record not found"));
	}
	
	@Test
	public void getCreditCardDetailsMissingAccNoTest() throws Exception {
		
		String getDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/GetCreditCardDetails/MissingParameters.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore  = Resources.toString(
				Resources.getResource("mock/frontend/configStore/ConfigStoreResponse_Application_Errors.json"), Charsets.UTF_8);
		
		String getDetailsRespose = Resources.toString(
				Resources.getResource("mock/backend/GetCreditCardDetails/FaultResponse.json"),
				Charsets.UTF_8);
		
		AdviceWith.adviceWith(camelContext,"getDetails",routeBuilder->

		{
			routeBuilder.replaceFromWith("direct:getDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getDetailsRespose);
			}
		});
		
		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();
		
		GetCreditCardRequest oGetCreditCardRequest = objectMapper.readValue(getDetailsRequest, GetCreditCardRequest.class);
		
		String missingAccno = producerTemplate.requestBody("direct:getDetails", oGetCreditCardRequest, String.class);
	
		System.out.println("Missing Accno : " + missingAccno);
		
		Assertions.assertTrue(missingAccno.contains("Mandatory Value is missing"));
	}

//	@Test
//	public void getCreditCardDetailsMissingCardTypeTest() throws Exception {
//		
//		String getDetailsRequest = Resources.toString(
//				Resources.getResource("mock/GetCreditCardDetails/Frontend/GetCreditCardMissingCardType.json"), Charsets.UTF_8);
//
//		String ApplicationErrorConfigStore  = Resources.toString(
//				Resources.getResource("mock/configStore/ConfigStoreResponse_Application_Errors.json"), Charsets.UTF_8);
//		
//		String getDetailsRespose = Resources.toString(
//				Resources.getResource("mock/GetCreditCardDetails/Backend/GetCreditCardMissingCardTypeResponse.json"),
//				Charsets.UTF_8);
//		
//		AdviceWith.adviceWith(camelContext,"getDetails",routeBuilder->
//
//		{
//			routeBuilder.replaceFromWith("direct:getDetails");
//		});
//		
//		cdmockEndpoint.expectedMessageCount(1);
//		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
//			public void process(Exchange exchange) throws Exception {
//				exchange.getMessage().setBody(getDetailsRespose);
//			}
//		});
//		
//		configStore.expectedMessageCount(1);
//		configStore.whenAnyExchangeReceived(new Processor() {
//			public void process(Exchange exchange) throws Exception {
//				exchange.getMessage().setBody(ApplicationErrorConfigStore);
//			}
//		});
//		
//		camelContext.start();
//		
//		GetCreditCardRequest oGetCreditCardRequest = objectMapper.readValue(getDetailsRequest, GetCreditCardRequest.class);
//		
//		String missingCardType = producerTemplate.requestBody("direct:getDetails", oGetCreditCardRequest, String.class);
//	
//		System.out.println("Missing CardType: " + missingCardType);
//		
//		Assertions.assertTrue(missingCardType.contains("Record not found"));
//	}
	
	
	
}

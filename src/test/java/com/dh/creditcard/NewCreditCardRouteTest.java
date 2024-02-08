package com.dh.creditcard;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpointsAndSkip;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dh.creditcard.model.NewCreditCardRequest;
import com.dh.creditcard.model.NewCreditCardResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@UseAdviceWith
@CamelSpringBootTest
@SpringBootApplication
@WebAppConfiguration

@MockEndpointsAndSkip("http://localhost:8081/api/connector/configstore")

@ImportResource({ "classpath:spring/camel-context.xml" })
@PropertySource("classpath:application-test.properties")
@Configuration
@ComponentScan("com.dh.creditcard.*")
public class NewCreditCardRouteTest {

	@Autowired
	CamelContext camelContext;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ProducerTemplate producerTemplate;
	
	@EndpointInject("mock:http://localhost:8082/newcreditcard?bridgeEndpoint=true")
	private MockEndpoint cdmockEndpoint;
	
	@EndpointInject("mock:http://localhost:8081/api/connector/configstore")
    private MockEndpoint configStore;
	
	@Test
	public void newCreditCardTest() throws Exception{
		
		String getNewCreditCardRequest = Resources.toString(
				Resources.getResource("mock/NewCreditCard/frontend/NewCreditCardRequest.json"), Charsets.UTF_8);
		
		String ApplicationErrorConfigStore  = Resources.toString(
				Resources.getResource("mock/configStore/ConfigStoreResponse_Application_Errors.json"), Charsets.UTF_8);
		
		String getNewCreditCardRespose = Resources.toString(
				Resources.getResource("mock/NewCreditCard/backend/NewCreditCardResponse.json"),
				Charsets.UTF_8);
		
		AdviceWith.adviceWith(camelContext,"newCreditCard",routeBuilder->

		{
			routeBuilder.replaceFromWith("direct:newCreditCard");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getNewCreditCardRespose);
			}
		});
		
		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();
		
		NewCreditCardRequest oNewCreditCardRequest = objectMapper.readValue(getNewCreditCardRequest, NewCreditCardRequest.class);
		
		NewCreditCardResponse response = producerTemplate.requestBody("direct:newCreditCard", oNewCreditCardRequest, NewCreditCardResponse.class);
		
		Assertions.assertNotNull(response.getNewCreditCardResponse().getAccNo());
	}
}
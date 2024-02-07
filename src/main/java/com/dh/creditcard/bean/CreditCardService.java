package com.dh.creditcard.bean;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dh.creditcard.model.AddressType;
import com.dh.creditcard.model.CreditCardDetails;
import com.dh.creditcard.model.CustomerDetails;
import com.dh.creditcard.model.GetCardDetailsResponse;
import com.dh.creditcard.model.GetCreditCardRequest;
import com.dh.creditcard.model.GetCreditCardResponse;
import com.dh.creditcard.model.backend.CreditCardDetailsRequestBackend;
import com.dh.creditcard.model.backend.GetCreditCardRequestBackend;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CreditCardService {

	@Autowired
	ObjectMapper objectMapper;
	
	GetCreditCardRequestBackend oGetCreditCardRequestBackend = new GetCreditCardRequestBackend();
	
	public GetCreditCardRequestBackend prepareCreditCardRequest(GetCreditCardRequest getCreditCardRequest, Exchange exchange) throws Exception{
		
		CreditCardDetailsRequestBackend oCreditCardDetailsRequestBackend = new CreditCardDetailsRequestBackend();
		
		oCreditCardDetailsRequestBackend.setCardNumber(getCreditCardRequest.getCreditCardDetailsRequest().getCardNumber());
		oCreditCardDetailsRequestBackend.setCardType(getCreditCardRequest.getCreditCardDetailsRequest().getCardType());
		
		oGetCreditCardRequestBackend.setCreditCardDetailsRequest(oCreditCardDetailsRequestBackend);
		
		return oGetCreditCardRequestBackend;
	}
	
	public GetCreditCardResponse prepareCreditCardResponse(@Body JsonNode body, Exchange ex) throws Exception{
		
		JsonNode oCreditCardDetailsNode = body.get("CreditCardResponse");
		
		GetCreditCardResponse oGetCreditCardResponse = new GetCreditCardResponse();
		CreditCardDetails oCreditCardDetails = new CreditCardDetails();
		CustomerDetails oCustomerDetails = new CustomerDetails();
		AddressType oAddressType = new AddressType();
		GetCardDetailsResponse oCardDetails = new GetCardDetailsResponse();
		
		oCustomerDetails.setAccNo(oCreditCardDetailsNode.get("accno").asInt());
		oCustomerDetails.setName(oCreditCardDetailsNode.get("name").asText());
		oCustomerDetails.setAge(oCreditCardDetailsNode.get("age").asInt());
		oCustomerDetails.setPhoneNumber(oCreditCardDetailsNode.get("phonenumber").asText());
		oCustomerDetails.setDob(oCreditCardDetailsNode.get("dob").asText());
		
		oAddressType.setCity(oCreditCardDetailsNode.get("city").asText());
		oAddressType.setPincode(oCreditCardDetailsNode.get("pincode").asText());
		
		oCardDetails.setCardNumber(oCreditCardDetailsNode.get("cardnumber").asLong());
		oCardDetails.setCardType(oCreditCardDetailsNode.get("cardtype").asText());
		oCardDetails.setCreditLimit(oCreditCardDetailsNode.get("creditlimit").asInt());
		oCardDetails.setHolderName(oCreditCardDetailsNode.get("holdername").asText());
		oCardDetails.setStatus(oCreditCardDetailsNode.get("status").asText());
		oCardDetails.setCibilScore(oCreditCardDetailsNode.get("cibilscore").asInt());
		oCardDetails.setBranchNo(oCreditCardDetailsNode.get("branchno").asInt());
		oCardDetails.setDeliveryMethod(oCreditCardDetailsNode.get("deliverymethod").asText());
		oCardDetails.setEmployeeId(oCreditCardDetailsNode.get("employeeid").asInt());
		oCardDetails.setSalary(oCreditCardDetailsNode.get("salary").asInt());
		oCardDetails.setResponse(oCreditCardDetailsNode.get("response").asText());
		
		oCustomerDetails.setAddressType(oAddressType);
		oCustomerDetails.setCardDetails(oCardDetails);
		oCreditCardDetails.setCustomerDetails(oCustomerDetails);
		oGetCreditCardResponse.setCreditCardDetails(oCreditCardDetails);
		
		return oGetCreditCardResponse;
		
	}
}

package com.dh.creditcard.bean;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alahli.middleware.utility.bean.ErrorsService;
import org.apache.commons.lang3.StringUtils;
import com.dh.creditcard.model.AddressType;
import com.dh.creditcard.model.CardDetails;
import com.dh.creditcard.model.CardDetailsResponse;
import com.dh.creditcard.model.NewCreditCardDetails;
import com.dh.creditcard.model.NewCreditCardRequest;
import com.dh.creditcard.model.NewCreditCardResponse;
import com.dh.creditcard.model.NewCreditCardResponseDetails;
import com.dh.creditcard.model.NewCustomer;
import com.dh.creditcard.model.backend.AddressTypeBackend;
import com.dh.creditcard.model.backend.CardDetailsBackend;
import com.dh.creditcard.model.backend.NewCreditCardDetailsBackend;
import com.dh.creditcard.model.backend.NewCreditCardRequestBackend;
import com.dh.creditcard.model.backend.NewCustomerBackend;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class NewCreditCardService {

	@Autowired
	ErrorsService oErrorsService;
	
	NewCreditCardRequestBackend oNewCreditCardRequestBackend = new NewCreditCardRequestBackend();
	
	public NewCreditCardRequestBackend prepareNewCreditCardRequest(NewCreditCardRequest oNewCreditCardRequest,
			Exchange ex) throws Exception {
		
		// getting the values from frontend
		NewCreditCardDetails oNewCreditCardDetails = oNewCreditCardRequest.getNewCreditCardDetails();
		NewCustomer oNewCustomer = oNewCreditCardDetails.getNewCustomer();
		AddressType oAddressType = oNewCustomer.getAddressType();
		CardDetails oCardDetails = oNewCustomer.getCardDetails();
		
		// initilizing the backend class for mapping
//		NewCreditCardRequestBackend oNewCreditCardRequestBackend = new NewCreditCardRequestBackend();
		NewCreditCardDetailsBackend oNewCreditCardDetailsBackend = new NewCreditCardDetailsBackend();
		NewCustomerBackend oNewCustomerBackend = new NewCustomerBackend();
		AddressTypeBackend oAddressTypeBackend = new AddressTypeBackend();
		CardDetailsBackend oCardDetailsBackend = new CardDetailsBackend();
		
		// mapping frontend request to backend request
		oNewCustomerBackend.setAccNo(oNewCustomer.getAccNo());
		oNewCustomerBackend.setName(oNewCustomer.getName());
		oNewCustomerBackend.setAge(oNewCustomer.getAge());
		oNewCustomerBackend.setPhoneNumber(oNewCustomer.getPhoneNumber());
		oNewCustomerBackend.setDob(oNewCustomer.getDob());
		
		oAddressTypeBackend.setCity(oAddressType.getCity());
		oAddressTypeBackend.setPincode(oAddressType.getPincode());
		
		oCardDetailsBackend.setBranchNo(oCardDetails.getBranchNo());
		oCardDetailsBackend.setHolderName(oCardDetails.getHolderName());
		oCardDetailsBackend.setCibilScore(oCardDetails.getCibilScore());
		oCardDetailsBackend.setDeliveryMethod(oCardDetails.getDeliveryMethod());
		oCardDetailsBackend.setEmployeeId(oCardDetails.getEmployeeId());
		oCardDetailsBackend.setSalary(oCardDetails.getSalary());
		
		oNewCustomerBackend.setAddressType(oAddressTypeBackend);
		oNewCustomerBackend.setCardDetails(oCardDetailsBackend);
		oNewCreditCardDetailsBackend.setNewCustomerBackend(oNewCustomerBackend);
		oNewCreditCardRequestBackend.setNewCreditCardDetailsBackend(oNewCreditCardDetailsBackend);
		
		return oNewCreditCardRequestBackend;
		
	}
	
	public NewCreditCardResponse prepareNewCreditCardResponse(@Body JsonNode body, 
			Exchange exchange) throws Exception {
	
		JsonNode oNewCreditCardResponseNode = body.get("NewCreditCardResponse");
		
		
		NewCreditCardResponse oNewCreditCardResponse = new NewCreditCardResponse();
		NewCreditCardResponseDetails oNewCreditCardResponseDetails = new NewCreditCardResponseDetails();
		CardDetailsResponse oCardDetailsResponse = new CardDetailsResponse();
		
		oNewCreditCardResponseDetails.setAccNo(oNewCreditCardResponseNode.get("accNO").asInt());
		
		oCardDetailsResponse.setCardNumber(oNewCreditCardResponseNode.get("cardNumber").asLong());
		oCardDetailsResponse.setCardType(oNewCreditCardResponseNode.get("cardType").asText());
		oCardDetailsResponse.setStatus(oNewCreditCardResponseNode.get("status").asText());
		oCardDetailsResponse.setResponse(oNewCreditCardResponseNode.get("response").asText());
		
		oNewCreditCardResponseDetails.setCardDetails(oCardDetailsResponse);
		oNewCreditCardResponse.setNewCreditCardResponse(oNewCreditCardResponseDetails);
		
		return oNewCreditCardResponse;
	}
	
	public String checkPhoneNumber() throws Exception{
		
		String phoneNumber = oNewCreditCardRequestBackend.getNewCreditCardDetailsBackend().getNewCustomerBackend().getPhoneNumber();
		if(StringUtils.isNoneBlank(phoneNumber) && phoneNumber.length() != 10) {
			return oErrorsService.prepareAppErrorCust("INCORRECTVALUE", "PhoneNumber"); 
		}
		return "";
	}
}

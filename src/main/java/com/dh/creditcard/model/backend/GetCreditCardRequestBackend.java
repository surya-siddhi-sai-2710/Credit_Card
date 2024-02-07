package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CreditCardDetailsRequest"
})
public class GetCreditCardRequestBackend {

	@JsonProperty("CreditCardDetailsRequest")
	 private CreditCardDetailsRequestBackend creditCardDetailsRequest;

	public CreditCardDetailsRequestBackend getCreditCardDetailsRequest() {
		return creditCardDetailsRequest;
	}

	public void setCreditCardDetailsRequest(CreditCardDetailsRequestBackend creditCardDetailsRequest) {
		this.creditCardDetailsRequest = creditCardDetailsRequest;
	}

	@Override
	public String toString() {
		return "GetCreditCardRequestBackend [creditCardDetailsRequest=" + creditCardDetailsRequest + "]";
	}
}

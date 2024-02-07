package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CreditCardDetailsRequest"
})
public class GetCreditCardRequest {

	@JsonProperty("CreditCardDetailsRequest")
    private CreditCardDetailsRequest creditCardDetailsRequest;

    @JsonProperty("CreditCardDetailsRequest")
    public CreditCardDetailsRequest getCreditCardDetailsRequest() {
        return creditCardDetailsRequest;
    }

    @JsonProperty("CreditCardDetailsRequest")
    public void setCreditCardDetailsRequest(CreditCardDetailsRequest creditCardDetailsRequest) {
        this.creditCardDetailsRequest = creditCardDetailsRequest;
    }

	@Override
	public String toString() {
		return "GetCreditCardRequest [creditCardDetailsRequest=" + creditCardDetailsRequest + "]";
	}

}

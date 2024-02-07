package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CreditCardDetails"
})
public class GetCreditCardResponse {

	@JsonProperty("CreditCardDetails")
    private CreditCardDetails creditCardDetails;

    @JsonProperty("CreditCardDetails")
    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

    @JsonProperty("CreditCardDetails")
    public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

	@Override
	public String toString() {
		return "GetCreditCardResponse [creditCardDetails=" + creditCardDetails + "]";
	}
}

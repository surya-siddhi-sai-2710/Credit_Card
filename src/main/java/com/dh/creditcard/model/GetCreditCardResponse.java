package com.dh.creditcard.model;

import java.util.Objects;
import java.util.function.BooleanSupplier;

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

	@Override
	public int hashCode() {
		return Objects.hash(creditCardDetails);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetCreditCardResponse other = (GetCreditCardResponse) obj;
		return Objects.equals(creditCardDetails, other.creditCardDetails);
	}

	
}

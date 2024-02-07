package com.dh.creditcard.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CustomerDetails"
})
public class CreditCardDetails {

	@JsonProperty("CustomerDetails")
    private CustomerDetails customerDetails;

    @JsonProperty("CustomerDetails")
    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    @JsonProperty("CustomerDetails")
    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

	@Override
	public String toString() {
		return "CreditCardDetails [customerDetails=" + customerDetails + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerDetails);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCardDetails other = (CreditCardDetails) obj;
		return Objects.equals(customerDetails, other.customerDetails);
	}

}

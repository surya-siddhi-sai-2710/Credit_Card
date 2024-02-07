package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "NewCustomer"
})
public class NewCreditCardDetails {

	@JsonProperty("NewCustomer")
    private NewCustomer newCustomer;

    @JsonProperty("NewCustomer")
    public NewCustomer getNewCustomer() {
        return newCustomer;
    }

    @JsonProperty("NewCustomer")
    public void setNewCustomer(NewCustomer newCustomer) {
        this.newCustomer = newCustomer;
    }

	@Override
	public String toString() {
		return "NewCreditCardDetails [newCustomer=" + newCustomer + "]";
	}

}

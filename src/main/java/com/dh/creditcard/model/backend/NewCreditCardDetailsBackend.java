package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardDetailsBackend {

	@JsonProperty("NewCustomer")
    private NewCustomerBackend newCustomerBackend;

	public NewCustomerBackend getNewCustomerBackend() {
		return newCustomerBackend;
	}

	public void setNewCustomerBackend(NewCustomerBackend newCustomerBackend) {
		this.newCustomerBackend = newCustomerBackend;
	}

	@Override
	public String toString() {
		return "NewCreditCardDetailsBackend [newCustomerBackend=" + newCustomerBackend + "]";
	}
	
}

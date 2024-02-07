package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardRequestBackend {

	@JsonProperty("NewCreditCardRequest")
    private NewCreditCardDetailsBackend newCreditCardDetailsBackend;

	public NewCreditCardDetailsBackend getNewCreditCardDetailsBackend() {
		return newCreditCardDetailsBackend;
	}

	public void setNewCreditCardDetailsBackend(NewCreditCardDetailsBackend newCreditCardDetailsBackend) {
		this.newCreditCardDetailsBackend = newCreditCardDetailsBackend;
	}

	@Override
	public String toString() {
		return "NewCreditCardRequestBackend [newCreditCardDetailsBackend=" + newCreditCardDetailsBackend + "]";
	}
}

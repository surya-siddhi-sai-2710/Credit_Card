package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardResponseBackend {

	@JsonProperty("NewCreditCardResponse")
    private NewCreditCardResponseDetailsBackend newCreditCardResponseBackend;

	public NewCreditCardResponseDetailsBackend getNewCreditCardResponseBackend() {
		return newCreditCardResponseBackend;
	}

	public void setNewCreditCardResponseBackend(NewCreditCardResponseDetailsBackend newCreditCardResponseBackend) {
		this.newCreditCardResponseBackend = newCreditCardResponseBackend;
	}

	@Override
	public String toString() {
		return "NewCreditCardResponseBackend [newCreditCardResponseBackend=" + newCreditCardResponseBackend + "]";
	}
}

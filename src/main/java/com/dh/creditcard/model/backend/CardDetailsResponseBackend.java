package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDetailsResponseBackend {

	@JsonProperty("cardNumber")
	private String cardNumber;
	@JsonProperty("cardType")
	private String cardType;
	@JsonProperty("status")
	private String status;
	@JsonProperty("response")
	private String response;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "CardDetailsResponseBackend [cardNumber=" + cardNumber + ", cardType=" + cardType + ", status=" + status
				+ ", response=" + response + "]";
	}
}

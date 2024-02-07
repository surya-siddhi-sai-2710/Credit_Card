package com.dh.creditcard.model.backend;

import com.dh.creditcard.model.CardDetailsResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCreditCardResponseDetailsBackend {

	@JsonProperty("accNo")
	private Integer accNo;
	@JsonProperty("CardDetails")
	private CardDetailsResponse cardDetails;

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public CardDetailsResponse getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetailsResponse cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		return "NewCreditCardResponseDetailsBackend [accNo=" + accNo + ", cardDetails=" + cardDetails + "]";
	}

}

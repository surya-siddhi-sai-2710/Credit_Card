package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardNumber",
    "cardType"
})
public class CreditCardDetailsRequest {

	@JsonProperty("cardNumber")
    private Long cardNumber;
    @JsonProperty("cardType")
    private String cardType;

    @JsonProperty("cardNumber")
    public Long getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    @JsonProperty("cardType")
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

	@Override
	public String toString() {
		return "CreditCardDetailsRequest [cardNumber=" + cardNumber + ", cardType=" + cardType + "]";
	}

}

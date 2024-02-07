package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardNumber",
    "cardType"
})
public class CreditCardDetailsRequestBackend {

	@JsonProperty("cardNumber")
    private long cardNumber;
    @JsonProperty("cardType")
    private String cardType;

    @JsonProperty("cardNumber")
    public long getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(long cardNumber) {
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

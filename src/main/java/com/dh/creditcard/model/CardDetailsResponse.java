package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardNumber",
    "cardType",
    "status",
    "response"
})
public class CardDetailsResponse {

	@JsonProperty("cardNumber")
    private Long cardNumber;
    @JsonProperty("cardType")
    private String cardType;
    @JsonProperty("status")
    private String status;
    @JsonProperty("response")
    private String response;

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

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

	@Override
	public String toString() {
		return "CardDetailsResponse [cardNumber=" + cardNumber + ", cardType=" + cardType + ", status=" + status
				+ ", response=" + response + "]";
	}
}

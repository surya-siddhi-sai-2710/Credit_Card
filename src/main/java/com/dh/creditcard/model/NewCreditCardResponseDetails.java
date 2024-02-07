package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accNo",
    "CardDetails"
})
public class NewCreditCardResponseDetails {

	 @JsonProperty("accNo")
	    private Integer accNo;
	    @JsonProperty("CardDetails")
	    private CardDetailsResponse cardDetails;

	    @JsonProperty("accNo")
	    public Integer getAccNo() {
	        return accNo;
	    }

	    @JsonProperty("accNo")
	    public void setAccNo(Integer accNo) {
	        this.accNo = accNo;
	    }

	    @JsonProperty("CardDetails")
	    public CardDetailsResponse getCardDetails() {
	        return cardDetails;
	    }

	    @JsonProperty("CardDetails")
	    public void setCardDetails(CardDetailsResponse cardDetails) {
	        this.cardDetails = cardDetails;
	    }

		@Override
		public String toString() {
			return "NewCreditCardResponseDetails [accNo=" + accNo + ", cardDetails=" + cardDetails + "]";
		}

}

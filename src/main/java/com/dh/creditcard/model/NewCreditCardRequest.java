package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "NewCreditCardDetails"
})
public class NewCreditCardRequest {

	 @JsonProperty("NewCreditCardRequest")
	    private NewCreditCardDetails newCreditCardDetails;

	    @JsonProperty("NewCreditCardDetails")
	    public NewCreditCardDetails getNewCreditCardDetails() {
	        return newCreditCardDetails;
	    }

	    @JsonProperty("NewCreditCardDetails")
	    public void setNewCreditCardDetails(NewCreditCardDetails newCreditCardDetails) {
	        this.newCreditCardDetails = newCreditCardDetails;
	    }

		@Override
		public String toString() {
			return "NewCreditCardRequest [newCreditCardDetails=" + newCreditCardDetails + "]";
		}
}

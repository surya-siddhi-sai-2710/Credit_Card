package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "NewCreditCardResponse"
})
public class NewCreditCardResponse {

	 @JsonProperty("NewCreditCardResponse")
	    private NewCreditCardResponseDetails newCreditCardResponse;

	    @JsonProperty("NewCreditCardResponse")
	    public NewCreditCardResponseDetails getNewCreditCardResponse() {
	        return newCreditCardResponse;
	    }

	    @JsonProperty("NewCreditCardResponse")
	    public void setNewCreditCardResponse(NewCreditCardResponseDetails newCreditCardResponse) {
	        this.newCreditCardResponse = newCreditCardResponse;
	    }

		@Override
		public String toString() {
			return "NewCreditCardResponse [newCreditCardResponse=" + newCreditCardResponse + "]";
		}

}

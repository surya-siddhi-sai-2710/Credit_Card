package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accNo",
    "name",
    "age",
    "dob",
    "AddressType",
    "CardDetails"
})
public class CustomerDetails {

	 @JsonProperty("accNo")
	    private Integer accNo;
	    @JsonProperty("name")
	    private String name;
	    @JsonProperty("age")
	    private Integer age;
		@JsonProperty("phoneNumber")
	    private String phoneNumber;
	    @JsonProperty("dob")
	    private String dob;
	    @JsonProperty("AddressType")
	    private AddressType addressType;
	    @JsonProperty("CardDetails")
	    private GetCardDetailsResponse cardDetails;

	    @JsonProperty("accNo")
	    public Integer getAccNo() {
	        return accNo;
	    }

	    @JsonProperty("accNo")
	    public void setAccNo(Integer accNo) {
	        this.accNo = accNo;
	    }

	    @JsonProperty("name")
	    public String getName() {
	        return name;
	    }

	    @JsonProperty("name")
	    public void setName(String name) {
	        this.name = name;
	    }

	    @JsonProperty("age")
	    public Integer getAge() {
	        return age;
	    }

	    @JsonProperty("age")
	    public void setAge(Integer age) {
	        this.age = age;
	    }
	    
	    public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

	    @JsonProperty("dob")
	    public String getDob() {
	        return dob;
	    }

	    @JsonProperty("dob")
	    public void setDob(String dob) {
	        this.dob = dob;
	    }

	    @JsonProperty("AddressType")
	    public AddressType getAddressType() {
	        return addressType;
	    }

	    @JsonProperty("AddressType")
	    public void setAddressType(AddressType addressType) {
	        this.addressType = addressType;
	    }

	    @JsonProperty("CardDetails")
	    public GetCardDetailsResponse getCardDetails() {
	        return cardDetails;
	    }

	    @JsonProperty("CardDetails")
	    public void setCardDetails(GetCardDetailsResponse cardDetails) {
	        this.cardDetails = cardDetails;
	    }

		@Override
		public String toString() {
			return "CustomerDetails [accNo=" + accNo + ", name=" + name + ", age=" + age + ", dob=" + dob + ", addressType="
					+ addressType + ", cardDetails=" + cardDetails + "]";
		}
}

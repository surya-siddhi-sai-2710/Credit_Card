package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCustomerBackend {

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
	private AddressTypeBackend addressType;
	@JsonProperty("CardDetails")
	private CardDetailsBackend cardDetails;

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public AddressTypeBackend getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressTypeBackend addressType) {
		this.addressType = addressType;
	}

	public CardDetailsBackend getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetailsBackend cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		return "NewCustomerBackend [accNo=" + accNo + ", name=" + name + ", age=" + age + ", dob=" + dob
				+ ", addressType=" + addressType + ", cardDetails=" + cardDetails + "]";
	}
}

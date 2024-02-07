package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCardDetailsResponse {

	@JsonProperty("cardNumber")
	private Long cardNumber;
	
	@JsonProperty("cardType")
	private String cardType;

	@JsonProperty("branchNo")
	private int branchNo;
	
	@JsonProperty("creditLimit")
	private int creditLimit;
	
	@JsonProperty("holderName")
	private String holderName;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("cibilScore")
	private int cibilScore;
	
	@JsonProperty("deliveryMethod")
	private String deliveryMethod;
	
	@JsonProperty("employeeId")
	private int employeeId;
	
	@JsonProperty("salary")
	private int salary;
	
	@JsonProperty("response")
	private String response;

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "GetCardDetailsResponse [cardNumber=" + cardNumber + ", cardType=" + cardType + ", branchNo=" + branchNo
				+ ", creditLimit=" + creditLimit + ", holderName=" + holderName + ", status=" + status + ", cibilScore="
				+ cibilScore + ", deliveryMethod=" + deliveryMethod + ", employeeId=" + employeeId + ", salary="
				+ salary + ", response=" + response + "]";
	}
}

package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDetailsBackend {

	@JsonProperty("cardNumber")
	private long cardNumber;
	@JsonProperty("cardType")
	private String cardType;
	@JsonProperty("branchNo")
	private Integer branchNo;
	@JsonProperty("creditLimit")
	private Integer creditLimit;
	@JsonProperty("holderName")
	private String holderName;
	@JsonProperty("status")
	private String status;
	@JsonProperty("cibilScore")
	private Integer cibilScore;
	@JsonProperty("deliveryMethod")
	private String deliveryMethod;
	@JsonProperty("employeeId")
	private Integer employeeId;
	@JsonProperty("salary")
	private Integer salary;
	@JsonProperty("response")
	private String response;

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(Integer branchNo) {
		this.branchNo = branchNo;
	}

	public Integer getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Integer creditLimit) {
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

	public Integer getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(Integer cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
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
		return "CardDetailsBackend [cardNumber=" + cardNumber + ", cardType=" + cardType + ", branchNo=" + branchNo
				+ ", creditLimit=" + creditLimit + ", holderName=" + holderName + ", status=" + status + ", cibilScore="
				+ cibilScore + ", deliveryMethod=" + deliveryMethod + ", employeeId=" + employeeId + ", salary="
				+ salary + ", response=" + response + "]";
	}
}

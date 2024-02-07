package com.dh.creditcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardNumber",
    "cardType",
    "branchNo",
    "creditLimit",
    "holderName",
    "status",
    "cibilScore",
    "deliveryMethod",
    "employeeId",
    "salary",
    "response"
})
public class CardDetails {

	@JsonProperty("cardNumber")
    private Long cardNumber;
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
    
    
    public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}



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

    @JsonProperty("branchNo")
    public Integer getBranchNo() {
        return branchNo;
    }

    @JsonProperty("branchNo")
    public void setBranchNo(Integer branchNo) {
        this.branchNo = branchNo;
    }

    @JsonProperty("creditLimit")
    public Integer getCreditLimit() {
        return creditLimit;
    }

    @JsonProperty("creditLimit")
    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @JsonProperty("holderName")
    public String getHolderName() {
        return holderName;
    }

    @JsonProperty("holderName")
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("cibilScore")
    public Integer getCibilScore() {
        return cibilScore;
    }

    @JsonProperty("cibilScore")
    public void setCibilScore(Integer cibilScore) {
        this.cibilScore = cibilScore;
    }

    @JsonProperty("deliveryMethod")
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    @JsonProperty("deliveryMethod")
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @JsonProperty("employeeId")
    public Integer getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("employeeId")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @JsonProperty("salary")
    public Integer getSalary() {
        return salary;
    }

    @JsonProperty("salary")
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", cardType=" + cardType + ", branchNo=" + branchNo
				+ ", creditLimit=" + creditLimit + ", holderName=" + holderName + ", status=" + status + ", cibilScore="
				+ cibilScore + ", deliveryMethod=" + deliveryMethod + ", employeeId=" + employeeId + ", salary="
				+ salary + ", response=" + response + "]";
	}
}

package com.dh.creditcard.model.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressTypeBackend {

	@JsonProperty("city")
	private String city;
	@JsonProperty("pincode")
	private String pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AddressTypeBackend [city=" + city + ", pincode=" + pincode + "]";
	}

}

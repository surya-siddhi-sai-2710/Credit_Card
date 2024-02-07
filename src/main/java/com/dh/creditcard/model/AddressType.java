package com.dh.creditcard.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city",
    "pincode"
})
public class AddressType {

	@JsonProperty("city")
    private String city;
    @JsonProperty("pincode")
    private String pincode;

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("pincode")
    public String getPincode() {
        return pincode;
    }

    @JsonProperty("pincode")
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

	@Override
	public String toString() {
		return "AddressType [city=" + city + ", pincode=" + pincode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, pincode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressType other = (AddressType) obj;
		return Objects.equals(city, other.city) && Objects.equals(pincode, other.pincode);
	}


}

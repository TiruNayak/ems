package com.code.ems.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Address {
	
	@NotNull(message="Address.city cannot be null")
	@Size(min=1,max=30)
	private String city;
	
	@NotNull(message="Address.state cannot be null")
	@Size(min=1,max=30)
	private String state;
	
	@NotNull(message="Address.country cannot be null")
	@Size(min=1,max=30)
	private String country;
	
	@NotNull(message="Address.pincode cann't be null")
	@Min(1)
	private int pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Address() {}


	public Address(String city, String state, String country, int pincode) {
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
}

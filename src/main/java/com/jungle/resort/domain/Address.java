package com.jungle.resort.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
	private String city;
	private String zip;
	
	@Size(min = 1, message = "Cannot be empty")
	private String state;
	
	@Size(min = 1, message = "Cannot be empty")
	private String country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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
}
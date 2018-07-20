package com.snkit.srpingjunedemo.vo;

public class AddressBuilder {

	
	private Long addId;
	
	private String street;
	
	private String country;
	
	private Long userId;

	public Long getAddId() {
		return addId;
	}

	public AddressBuilder setAddId(Long addId) {
		this.addId = addId;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public AddressBuilder setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public AddressBuilder setCountry(String country) {
		this.country = country;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public AddressBuilder setUserId(Long userId) {
		this.userId = userId;		
		return this;
	}
	
	public Address build() {
		return new Address(this);
	}
	
}

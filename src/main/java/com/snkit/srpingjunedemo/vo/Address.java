package com.snkit.srpingjunedemo.vo;

public class Address {

	
	public Address(AddressBuilder builder) {
		
		this.addId = builder.getAddId();
		this.street= builder.getStreet();		
		this.country = builder.getCountry();
		this.userId = builder.getUserId();
		
	}
	
	private Long addId;
	
	private String street;
	
	private String country;
	
	private Long userId;

	public Long getAddId() {
		return addId;
	}

	public String getStreet() {
		return street;
	}

	public String getCountry() {
		return country;
	}

	public Long getUserId() {
		return userId;
	}
	
	
}

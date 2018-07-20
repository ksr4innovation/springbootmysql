package com.snkit.srpingjunedemo.vo;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	
	public User(UserBuilder builder) {
		this.id= builder.getId();
		this.name = builder.getName();
		this.email = builder.getEmail();
		
		addList = new ArrayList<Address>();	
	}
	
	private List<Address> addList;
	
	private Long id;
	
	private String email;
	
	private String name;

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public List<Address> getAddList() {
		return addList;
	}

	public void setAddList(List<Address> addList) {
		this.addList = addList;
	}
	
	

}

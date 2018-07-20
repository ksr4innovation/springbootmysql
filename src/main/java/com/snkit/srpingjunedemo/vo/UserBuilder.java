package com.snkit.srpingjunedemo.vo;

public class UserBuilder {
	
	
	private Long id;
	
	private String email;
	
	private String name;

	public Long getId() {
		return id;
	}

	public UserBuilder setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public User build() {
		return new User(this);
	}

}

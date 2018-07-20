package com.snkit.srpingjunedemo.vo;

import java.util.ArrayList;
import java.util.List;

public class UserResp {
	
	public UserResp() {
		
	}

	private List<User> userList = new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}

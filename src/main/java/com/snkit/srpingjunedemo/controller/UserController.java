package com.snkit.srpingjunedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snkit.srpingjunedemo.service.UserService;
import com.snkit.srpingjunedemo.vo.UserReq;
import com.snkit.srpingjunedemo.vo.UserResp;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping(value="/getUsers")
	public UserResp getUsers() {
		
		return userService.getUsers();
		
		
		
	}
	@PostMapping(value="/findUser")
	public void findUser(@RequestBody UserReq req) {
		userService.findUser(req);
		
	}
}

package com.snkit.srpingjunedemo.advice;

public class DemoError {
	
	private String code;
	private String msg;
	public DemoError(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	

}

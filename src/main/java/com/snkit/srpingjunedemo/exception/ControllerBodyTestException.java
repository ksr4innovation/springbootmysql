package com.snkit.srpingjunedemo.exception;

public class ControllerBodyTestException extends RuntimeException {
	private String msg;
	
	private String code;
	
	
	public ControllerBodyTestException(String code, String msg){
		super(msg);
		this.msg = msg;
		this.code = code;
		
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getCode() {
		return code;
	}
	
	
}

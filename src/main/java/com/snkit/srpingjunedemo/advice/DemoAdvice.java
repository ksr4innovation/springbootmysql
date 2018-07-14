package com.snkit.srpingjunedemo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.snkit.srpingjunedemo.exception.ControllerBodyTestException;
import com.snkit.srpingjunedemo.exception.DemoException;

@ControllerAdvice
public class DemoAdvice {
	
	
	@ExceptionHandler(DemoException.class)
	public ResponseEntity<MultiValueMap> handleException(DemoException e){
		MultiValueMap map = new LinkedMultiValueMap();
		map.add("code", "CUST001");
		map.add("msg", e.getMsg());
		return new ResponseEntity(map,HttpStatus.OK);
	}

	@ExceptionHandler(ControllerBodyTestException.class)
	public ResponseEntity<DemoError> handleExceptionTest(ControllerBodyTestException e){
		
		DemoError error = new DemoError(e.getCode(),e.getMsg());
		
		
		return new ResponseEntity(error,HttpStatus.OK);
	}
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<DemoError> handleExceptionTestMedia(HttpMediaTypeNotSupportedException e){
		
		DemoError error = new DemoError("CUSTMEDIA",e.getMessage());
		
		
		return new ResponseEntity(error,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
}

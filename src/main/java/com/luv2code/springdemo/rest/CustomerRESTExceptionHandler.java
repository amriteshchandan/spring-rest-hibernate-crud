package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRESTExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerRESTErrorResponse> handleException(CustomerNotFoundException customerNotFoundException) {
		
		CustomerRESTErrorResponse customerRESTErrorResponse = 
				new CustomerRESTErrorResponse(HttpStatus.NOT_FOUND.value(), customerNotFoundException.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(customerRESTErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerRESTErrorResponse> handleException(Exception exception) {
		
		CustomerRESTErrorResponse customerRESTErrorResponse = 
				new CustomerRESTErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(customerRESTErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
}

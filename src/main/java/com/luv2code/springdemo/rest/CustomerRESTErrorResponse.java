package com.luv2code.springdemo.rest;

public class CustomerRESTErrorResponse {

	private int status;
	private String message;
	private long timesStamp;
	
	public CustomerRESTErrorResponse() {}
	
	public CustomerRESTErrorResponse(int status, String message, long timesStamp) {
		this.status = status;
		this.message = message;
		this.timesStamp = timesStamp;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimesStamp() {
		return timesStamp;
	}
	public void setTimesStamp(long timesStamp) {
		this.timesStamp = timesStamp;
	}
	
}

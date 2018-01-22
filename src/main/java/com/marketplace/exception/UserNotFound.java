package com.marketplace.exception;

public class UserNotFound extends Exception{
	public UserNotFound(String errorCode,String errorMessage) {
		// TODO Auto-generated constructor stub
		super(errorMessage);
		
	}
}

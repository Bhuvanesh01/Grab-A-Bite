package com.grababiteapp.exception;

public class UserAlreadyPresentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserAlreadyPresentException() {
		super();	
	}
	public  UserAlreadyPresentException(String message) {
		super(message);
	}
	

}

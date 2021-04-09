package com.grababiteapp.exception;

public class UserAlreadyThereException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserAlreadyThereException() {
		super();	
	}
	public  UserAlreadyThereException(String message) {
		super(message);
	}
	

}

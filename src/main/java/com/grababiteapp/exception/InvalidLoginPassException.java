package com.grababiteapp.exception;

public class InvalidLoginPassException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidLoginPassException() {
		super();	
	}
	public  InvalidLoginPassException(String message) {
		super(message);
	}
	

}

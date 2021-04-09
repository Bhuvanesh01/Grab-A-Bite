package com.grababiteapp.exception;

public class NotSufficientBalanceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NotSufficientBalanceException() {
		super();	
	}
	public  NotSufficientBalanceException(String message) {
		super(message);
	}
	

}

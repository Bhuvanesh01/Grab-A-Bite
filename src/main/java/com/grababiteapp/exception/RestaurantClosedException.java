package com.grababiteapp.exception;

public class RestaurantClosedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RestaurantClosedException() {
		super();	
	}
	public  RestaurantClosedException(String message) {
		super(message);
	}
	

}

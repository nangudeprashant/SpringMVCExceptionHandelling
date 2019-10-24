package com.javaLive.exception;

public class ElectricityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ElectricityNotFoundException(String villageName) {
		super(villageName+":Electricity not available");
	}
} 

package com.project.foodapp.exception;

public class ProductNotFoundById extends RuntimeException {
	
	private String message;
	
	
	
	public ProductNotFoundById(String message) {
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	
	
	
}

package com.project.foodapp.exception;

public class MenuNotFoundByIdException extends RuntimeException {
private String message;
	
	
	
	public MenuNotFoundByIdException(String message) {
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
}

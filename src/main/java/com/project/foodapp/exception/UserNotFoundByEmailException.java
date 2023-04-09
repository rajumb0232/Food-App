package com.project.foodapp.exception;

public class UserNotFoundByEmailException extends RuntimeException{
	String message;

	public UserNotFoundByEmailException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}

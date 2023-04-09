package com.project.foodapp.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.foodapp.config.ResponceStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	// method to handle exceptions from field validations
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> ref = ex.getAllErrors();
		HashMap< String, String> field = new HashMap<>();
		for(ObjectError error : ref) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			field.put(fieldName ,message);
		}
		return new ResponseEntity<Object>(field, HttpStatus.BAD_REQUEST);
	}
	
	
	// methods to handle exceptions of custom exception classes
	
	// IdNotFoundException class for user
	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> idNotFound(IdNotFoundException ex){
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("User not present with the with requested Id!");
		return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	// ProductNotFoundById
	@org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundById.class)
	public ResponseEntity<ResponceStructure<String>> productNotFoundById(ProductNotFoundById ex){
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Product not present with the requested Id!");
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	// UserNotFoundByEmailException
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundByEmailException.class)
	public ResponseEntity<ResponceStructure<String>> UserNotFoundByEmail(UserNotFoundByEmailException ex){
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("User not present with the requested Email!");
		return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	// MenuNotFoundByIdException.java
	@org.springframework.web.bind.annotation.ExceptionHandler(MenuNotFoundByIdException.class)
	public ResponseEntity<ResponceStructure<String>> MenuNotFoundById(MenuNotFoundByIdException ex){
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Menu not present with the requested Id!");
		 return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	


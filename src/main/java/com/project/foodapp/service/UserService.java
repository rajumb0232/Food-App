package com.project.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dao.UserDAO;
import com.project.foodapp.dto.User;
import com.project.foodapp.exception.IdNotFoundException;
import com.project.foodapp.exception.UserNotFoundByEmailException;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public ResponseEntity<ResponceStructure<User>> findUser(long userId) {
		ResponceStructure<User>  structure = new ResponceStructure<>();
		User user = dao.findUser(userId);
		if(user!=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("User Found!");
			structure.setData(user);
			return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			 throw new IdNotFoundException("Unable to find User!");
		}
		
	}
	
	public ResponseEntity<ResponceStructure<User>> updateUser(User user, long userId) {
		ResponceStructure<User>  structure = new ResponceStructure<>();
		User user2 = dao.updateUser(user, userId);
		if(user2 != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User Successfully Update!");
			structure.setData(user2);
			return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Unable to update User!");
		}
	}
	
	public ResponseEntity<ResponceStructure<User>> deleteUser(long userId) {
		ResponceStructure<User>  structure = new ResponceStructure<>();
		User user = dao.deleteUser(userId);
		if(user != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User Successfully Deleted!");
			structure.setData(user);
			return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Unable to delete the User!");
		}
		
	}
	
	public ResponseEntity<ResponceStructure<User>> findUserByEmail(String userEmail){
		ResponceStructure<User> structure = new ResponceStructure<>();
		User user = dao.findUserByEmail(userEmail);
		if(user!=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("User found with the requested Email.");
			structure.setData(user);
			return new ResponseEntity<ResponceStructure<User>> (structure, HttpStatus.FOUND);
		}else {
			throw new UserNotFoundByEmailException("User not found with the requested Email!");
			
		}
	}
}






















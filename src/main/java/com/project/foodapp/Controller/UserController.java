package com.project.foodapp.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dto.User;
import com.project.foodapp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "Save User", notes = "API is used to save the User!")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Successfully created!"),
			@ApiResponse(code = 400, message = "Invalid Details!")
			
	})
	@PostMapping
	public User saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}
	
	
	@ApiOperation(value = "Find User", notes = "API used to fetch the user based on the Id!")
	@ApiResponses({
			@ApiResponse(code = 302, message = "Successfully Found User!"),
			@ApiResponse(code = 404, message = "User not found with requested Id!")
			
	})
	@GetMapping("/{id}")
	public ResponseEntity<ResponceStructure<User>> getUser(@PathVariable long id) {
		return service.findUser(id);
	}
	
	@ApiOperation(value = "Update User", notes = "API used to update the user based on the given Id!")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully updted the User!"),
			@ApiResponse(code = 404, message = "User not found with requested Id!")
			
	})
	@PutMapping("/{userId}")
	public ResponseEntity<ResponceStructure<User>> updateUser(@RequestBody User user,@PathVariable long userId) {
		return service.updateUser(user, userId);
	}
	
	@ApiOperation(value = "Delete User", notes = "API used to delete the user based on the given Id!")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully deleted the User!"),
			@ApiResponse(code = 404, message = "User not found with requested Id!")
			
	})
	@DeleteMapping("/{userId}")
	public ResponseEntity<ResponceStructure<User>> deleteUser(@PathVariable long userId) {
		return service.deleteUser(userId);
	}
}

package com.project.foodapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dto.Menu;
import com.project.foodapp.service.MenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@ApiOperation(value = "Save Menu", notes = "API is used to save the Menu.")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Successfully created Menu!"),
			@ApiResponse(code = 400, message = "Invalid Details!")
			
	})
	@PostMapping
	public  Menu  saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}
	
	@ApiOperation(value = "Find Menu", notes = "API is used to find the Menu based on the reqested Id.")
	@ApiResponses({
		@ApiResponse(code = 302, message = "Successfully found Menu!"),
		@ApiResponse(code = 404, message = "Failed to find menu with the requested Id!")
	})
	@GetMapping("/{menuId}")
	public ResponseEntity<ResponceStructure<Menu>> findMenu(@PathVariable int menuId) {
		return service.findMenu(menuId);
	}
	
	@ApiOperation(value = "Update Menu", notes = "API is used to update the Menu for the reqested Id.")
	@ApiResponses({
		@ApiResponse(code = 302, message = "Successfully updated Menu!"),
		@ApiResponse(code = 404, message = "Failed to update menu for the requested Id!")
	})
	@PutMapping("/{id}")
	public ResponseEntity<ResponceStructure<Menu>> updateMenu(@RequestBody Menu menu, @PathVariable int id) {
		return service.updateMenu(menu, id);
	}
	
	@ApiOperation(value = "Delete Menu", notes = "API is used to delete the Menu with the reqested Id.")
	@ApiResponses({
		@ApiResponse(code = 302, message = "Successfully delete Menu!"),
		@ApiResponse(code = 404, message = "Failed to delete menu with the requested Id!")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponceStructure<Menu>> deleteMenu(@PathVariable int id) {
		return service.deleteMenu(id);
	}
}


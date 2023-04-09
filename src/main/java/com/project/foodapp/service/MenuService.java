package com.project.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dao.MenuDAO;
import com.project.foodapp.dto.Menu;
import com.project.foodapp.exception.MenuNotFoundByIdException;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Stubbing;

@Service
public class MenuService {
	
	@Autowired
	private MenuDAO dao;
	
	public Menu saveMenu(Menu menu) {
		return dao.saveMenu(menu);
	}
	
	public ResponseEntity<ResponceStructure<Menu>> findMenu(int menuId){
		ResponceStructure<Menu> structure = new ResponceStructure<>();
		Menu menu = dao.findMenu(menuId);
		if(menu!=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Menu Found!");
			structure.setData(menu);
			return new ResponseEntity<ResponceStructure<Menu>>(structure,HttpStatus.FOUND);
		}else {
			throw new MenuNotFoundByIdException("Menu not Found!");
		}
	}
	
	public ResponseEntity<ResponceStructure<Menu>> updateMenu(Menu menu, int menuId) {
		ResponceStructure<Menu> structure = new ResponceStructure<>();
		Menu menu2 =dao.updateMenu(menu, menuId);
		
		if(menu2!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Successfully updated Menu!");
			structure.setData(menu2);
			return new ResponseEntity<ResponceStructure<Menu>>(structure,HttpStatus.OK);
		}
		else {
			throw new MenuNotFoundByIdException("Failed to update Menu");
		}
	}
	
	public ResponseEntity<ResponceStructure<Menu>> deleteMenu(int menuId) {
		ResponceStructure<Menu> structure = new ResponceStructure<>();
		Menu menu = dao.deleteMenu(menuId);
		
		if(menu!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Successfully deleted Menu!");
			structure.setData(menu);
			return new ResponseEntity<ResponceStructure<Menu>>(structure,HttpStatus.OK);
		}else {
			throw new MenuNotFoundByIdException("Failed to delete Menu");
		}
	}
	
	
	
	
}

package com.project.foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dto.Menu;
import com.project.foodapp.repository.MenuRepository;

@Repository
public class MenuDAO {
	
	@Autowired
	private MenuRepository repository;
	
	public Menu saveMenu(Menu menu) {
		return repository.save(menu);
	}
	
	public Menu findMenu(int menuId) {
		
		Optional<Menu> optional = repository.findById(menuId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public Menu updateMenu(Menu menu, int menuId) {
		Optional<Menu> optional = repository.findById(menuId);
		if(optional.isEmpty()) {
			return null;
		}
		menu.setMenuId(menuId);
		return repository.save(menu);
	}
	
	public Menu deleteMenu(int menuId) {
		Optional<Menu> optional = repository.findById(menuId);
		if(optional.isEmpty()) {
			return null;
		}
		Menu menu = optional.get();
		repository.delete(menu);
		return menu;
	}
}

package com.project.foodapp.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.Item;
import com.project.foodapp.repository.ItemRepo;

@Repository
public class ItemDAO {
	
	@Autowired
	private ItemRepo itemRepo;
	
	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}
}

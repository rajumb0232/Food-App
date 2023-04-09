package com.project.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.repository.OrderRepo;

@Repository
public class OrderDAO {
	
	@Autowired
	private OrderRepo orderRepo;
	
	public FoodOrder saveOrder(FoodOrder foodOrder) {
		return orderRepo.save(foodOrder);
	}
	
	
	
}

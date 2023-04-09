package com.project.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dao.OrderDAO;
import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.dto.Item;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDao;
	
	public ResponseEntity<ResponceStructure<FoodOrder>> saveOrder(FoodOrder foodOrder) {
		ResponceStructure<FoodOrder> structure = new ResponceStructure<>();

		if(foodOrder!=null) {
			List<Item> items = foodOrder.getItems();
			double orderTotal = 0;
			for(Item item: items) {
				System.out.println(item.getItemQuatity()+" * "+item.getItemCost());
				orderTotal = orderTotal+(item.getItemCost()*item.getItemQuatity());
			}
			foodOrder.setOrderTotal(orderTotal);
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Order Placed");
			structure.setData(orderDao.saveOrder(foodOrder));
			return new ResponseEntity<ResponceStructure<FoodOrder>>(structure,HttpStatus.CREATED);
		}else {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMessage("Could Not Insert Data!");
			structure.setData(foodOrder);
			return new ResponseEntity<ResponceStructure<FoodOrder>>(structure,HttpStatus.BAD_REQUEST);
		}

		
	}
}

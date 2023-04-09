package com.project.foodapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<ResponceStructure<FoodOrder>> saveOrder(@RequestBody FoodOrder foodOrder){
		return orderService.saveOrder(foodOrder);
	}
}

package com.project.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodapp.dto.FoodOrder;

public interface OrderRepo extends JpaRepository<FoodOrder, Integer> {

}

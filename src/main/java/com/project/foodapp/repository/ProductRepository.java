package com.project.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodapp.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

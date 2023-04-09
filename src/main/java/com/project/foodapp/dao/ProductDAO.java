package com.project.foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.Product;
import com.project.foodapp.repository.ProductRepository;

@Repository
public class ProductDAO {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public Product findProduct(long productId) {
	Optional<Product> optional = repository.findById(productId);
		if(optional.isEmpty()) {
			return null;
		}
		
		return optional.get();
	}
	
	public Product updateProduct(Product product, long productId) {
		Optional<Product> optional = repository.findById(productId);
		if(optional.isEmpty()) {
			return null;
		}
		product.setProductId(productId);
		return repository.save(product);
	}
	
	public Product deleteProduct(long productId) {
		Optional<Product> optional = repository.findById(productId);
		if(optional.isEmpty()) {
			return null;
		}
		Product product = optional.get();
		repository.delete(product);
		return product;
	}
	
}

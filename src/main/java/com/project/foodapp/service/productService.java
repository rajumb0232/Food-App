package com.project.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dao.ProductDAO;
import com.project.foodapp.dto.Product;
import com.project.foodapp.dto.User;
import com.project.foodapp.exception.ProductNotFoundById;
import com.project.foodapp.repository.ProductRepository;

@Service
public class productService {
	
	@Autowired
	private ProductDAO dao;
	
	public Product saveProduct(Product product) {
		return dao.saveProduct(product);
	}
	
	public ResponseEntity<ResponceStructure<Product>> findProduct(long productId) {
		ResponceStructure<Product> structure = new ResponceStructure<>();
		Product product = dao.findProduct(productId);
		if(product != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("User Found!");
			structure.setData(product);
			return new ResponseEntity<ResponceStructure<Product>>(structure, HttpStatus.FOUND);
		}else {
			throw new ProductNotFoundById("Product Not Found!");
		}
	}
	
	public ResponseEntity<ResponceStructure<Product>> updateProduct(Product product, long productId) {
		ResponceStructure<Product> structure = new ResponceStructure<>();
		Product product2 = dao.updateProduct(product, productId);
		if(product2!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Product Successfully Updated!");
			structure.setData(product2);
			return new ResponseEntity<ResponceStructure<Product>>(structure,HttpStatus.OK);
		}else {
			throw new ProductNotFoundById("Could not update Product!");
		}
		
	}
	
//	public Product deleteproduct(long productId) {
//		return dao.deleteProduct(productId);
//	}
	
	
}

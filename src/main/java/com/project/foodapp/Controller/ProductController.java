package com.project.foodapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.config.ResponceStructure;
import com.project.foodapp.dto.Product;
import com.project.foodapp.service.productService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private productService service;
	
	@PostMapping
	public Product saveProduct(Product product) {
		return service.saveProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponceStructure<Product>> findProduct(@PathVariable long id) {
		return service.findProduct(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponceStructure<Product>> updateProduct(@RequestBody Product product, @PathVariable long id) {
		return service.updateProduct(product, id);
	}
	
//	@DeleteMapping("/{id}")
//	public Product deleteProduct(@PathVariable long id) {
//		return service.deleteproduct(id);
//	}
	
}

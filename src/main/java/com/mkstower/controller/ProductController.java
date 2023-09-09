package com.mkstower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.entity.Product;
import com.mkstower.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {
		Product savedProduct = productService.createProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("active")
	public ResponseEntity<List<Product>> getAllActiveProducts() {
		List<Product> products = productService.getAllActiveProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @Validated @RequestBody Product product) {
		Product updateProduct = productService.updateProduct(product, id);
		return new ResponseEntity<>(updateProduct, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product id " + id + " successfully deleted", HttpStatus.OK);
	}

}

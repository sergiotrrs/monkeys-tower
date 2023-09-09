package com.mkstower.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.Product;
import com.mkstower.repository.ProductRepository;
import com.mkstower.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {		
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("Product does not exist with id: " + id));		
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllActiveProducts() {		
		//return productRepository.findAll();
		List<Product> products = new ArrayList<>();
		products.add(new Product(100, "PC", "PC Laptop", "url", 23.12,2, null  ,null, false, null));
		return products;
	}

	@Override
	public Product updateProduct(Product product, long id) {
		Product existingProduct = getProductById(id);
		existingProduct.setName( product.getName());

		return createProduct(existingProduct);
	}

	@Override
	public void deleteProduct(long id) {
		Product existingProduct = getProductById(id);
		existingProduct.setActive(false);		
	}

}

package com.mkstower.service;

import java.util.List;

import com.mkstower.entity.Product;
import com.mkstower.entity.limits.ProductFieldLimits;

public interface ProductService extends ProductFieldLimits {

	Product createProduct(Product product);
	
	Product getProductById(long id);
	
	List<Product> getAllProducts();
	
	List<Product> getAllActiveProducts();
	
	Product updateProduct(Product product, long id);
	
	void deleteProduct(long id);
	
}

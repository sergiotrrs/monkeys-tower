package com.mkstower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.entity.OrderHasProduct;
import com.mkstower.service.OrderHasProductService;

@RestController
@RequestMapping("api/order-has-product")
public class OrderHasProductController {
	
	@Autowired
	OrderHasProductService orderHasProductService;
	
	@PostMapping
	public ResponseEntity<OrderHasProduct> createOrderHasProduct(@Validated @RequestBody OrderHasProduct orderHasProduct) {
		OrderHasProduct savedOrderHasProduct = orderHasProductService.createOrderHasProduct(orderHasProduct);
		return new ResponseEntity<>(savedOrderHasProduct, HttpStatus.CREATED);
	}

	@GetMapping("/query")
	public ResponseEntity<OrderHasProduct> getOrderHasProductById(
			@RequestParam long orderId,
			@RequestParam long productId
			) {
		OrderHasProduct orderHasProduct = orderHasProductService.getOrderHasProductById(orderId, productId);
		return new ResponseEntity<>(orderHasProduct, HttpStatus.OK);
	}


	@PutMapping("/query")
	public ResponseEntity<OrderHasProduct> updateOrderHasProduct(
			@RequestParam long orderId,
			@RequestParam long productId,
			@Validated @RequestBody OrderHasProduct orderHasProduct
			) {
		OrderHasProduct updateOrderHasProduct = orderHasProductService.updateOrderHasProduct(orderHasProduct, orderId, productId);
		return new ResponseEntity<>(updateOrderHasProduct, HttpStatus.OK);
	}

	@DeleteMapping("/query")
	public ResponseEntity<String> deleteOrderHasProduct(
			@RequestParam long orderId,
			@RequestParam long productId
			) {
		orderHasProductService.deleteOrderHasProduct(orderId, productId);
		return new ResponseEntity<>("Order id: " + orderId + "and product id: " + productId + " successfully deleted", HttpStatus.OK);
	}

}

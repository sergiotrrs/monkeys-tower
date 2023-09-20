package com.mkstower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.entity.Order;
import com.mkstower.service.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@Validated @RequestBody Order order) {
		Order savedOrder = orderService.createOrder(order);
		return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable long id) {
		Order order = orderService.getOrderById(id);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}


	@PutMapping("{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable long id, @Validated @RequestBody Order order) {
		Order updateOrder = orderService.updateOrder(order, id);
		return new ResponseEntity<>(updateOrder, HttpStatus.OK);
	}


}

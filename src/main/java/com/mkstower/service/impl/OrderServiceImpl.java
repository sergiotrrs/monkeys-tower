package com.mkstower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.Order;
import com.mkstower.repository.OrderRepository;
import com.mkstower.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {		
		return saveOrder(order);
	}
	
	public Order saveOrder(Order order) {		
		return orderRepository.save(order);
	}	

	@Override
	public Order getOrderById(long id) {
		return orderRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("Order does not exist with id: " + id));		
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}


	@Override
	public Order updateOrder(Order order, long id) {
		Order existingOrder = getOrderById(id);
		existingOrder.setTotalAmount( order.getTotalAmount() );
		return createOrder(existingOrder);
	}


}

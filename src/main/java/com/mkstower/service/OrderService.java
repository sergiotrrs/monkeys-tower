package com.mkstower.service;

import java.util.List;

import com.mkstower.entity.Order;
import com.mkstower.entity.limits.OrderFieldLimits;

public interface OrderService extends OrderFieldLimits {

	Order createOrder(Order order);
	
	Order getOrderById(long id);
	
	List<Order> getAllOrders();
		
	Order updateOrder(Order order, long id);
		
}

package com.mkstower.service;

import com.mkstower.entity.OrderHasProduct;


public interface OrderHasProductService {

	OrderHasProduct createOrderHasProduct(OrderHasProduct orderProduct);
	
	OrderHasProduct getOrderHasProductById(long orderId, long productId);	
	
	OrderHasProduct updateOrderHasProduct(OrderHasProduct orderProduct, long orderId, long productId);
	
	void deleteOrderHasProduct(long orderId, long productId);
	
}

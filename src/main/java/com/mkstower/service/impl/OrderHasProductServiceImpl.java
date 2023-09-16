package com.mkstower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.OrderHasProduct;
import com.mkstower.entity.compositekey.OrderProductKey;
import com.mkstower.repository.OrderHasProductRepository;
import com.mkstower.service.OrderHasProductService;

@Service
public class OrderHasProductServiceImpl implements OrderHasProductService {
	
	@Autowired
	private OrderHasProductRepository orderProductRepository;
	@Autowired
	private OrderProductKey orderProductKey;

	@Override
	public OrderHasProduct createOrderHasProduct(OrderHasProduct orderHasProduct) {		
		return orderProductRepository.save(orderHasProduct);
	}

	@Override
	public OrderHasProduct getOrderHasProductById(long orderId, long productId) {
		orderProductKey.setOrderId(orderId);
		orderProductKey.setProductId(productId);
		
		return orderProductRepository.findById( orderProductKey )
				.orElseThrow( ()-> new IllegalStateException (
						"OrderHasProduct does not exist with orderId: " + orderId + " and productId " + productId
						));		
	}

	@Override
	public OrderHasProduct updateOrderHasProduct(OrderHasProduct orderProduct, long orderId, long productId) {
		OrderHasProduct existingOrderHasProduct = getOrderHasProductById(orderId, productId);
		existingOrderHasProduct.setQuantity( orderProduct.getQuantity() );
		existingOrderHasProduct.setPrice( orderProduct.getPrice() );
		return createOrderHasProduct(existingOrderHasProduct);
	}

	@Override
	public void deleteOrderHasProduct(long orderId, long productId) {
		OrderHasProduct existingOrderHasProduct = getOrderHasProductById(orderId, productId);
		orderProductRepository.delete(existingOrderHasProduct);		
	}

}

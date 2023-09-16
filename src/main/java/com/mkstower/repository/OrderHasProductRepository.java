package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.OrderHasProduct;
import com.mkstower.entity.compositekey.OrderProductKey;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, OrderProductKey> {

}

package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.OrderHasProduct;

public interface OrderHasProductsRepository extends JpaRepository<OrderHasProduct, Long> {

}

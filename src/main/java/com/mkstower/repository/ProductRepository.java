package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

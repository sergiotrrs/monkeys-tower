package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkstower.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

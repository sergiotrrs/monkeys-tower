package com.mkstower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkstower.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT COUNT(p) > 0 FROM Product p JOIN p.categories c WHERE c.id = :categoryId")
    Boolean isCategoryInUse(@Param("categoryId") Long categoryId);

}

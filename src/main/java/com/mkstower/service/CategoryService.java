package com.mkstower.service;

import java.util.List;

import com.mkstower.entity.Category;
import com.mkstower.entity.limits.CategoryFieldLimits;

public interface CategoryService extends CategoryFieldLimits {

	Category createCategory(Category category);
	
	Category getCategoryById(long id);
	
	List<Category> getAllCategories();	
	
	Category updateCategory(Category category, long id);
	
	void deleteCategory(long id);
	
}

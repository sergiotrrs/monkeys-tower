package com.mkstower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.Category;
import com.mkstower.repository.CategoryRepository;
import com.mkstower.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {		
		return saveCategory(category);
	}
	
	public Category saveCategory(Category category) {		
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(long id) {
		return categoryRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("Category does not exist with id: " + id));		
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category updateCategory(Category category, long id) {
		Category existingCategory = getCategoryById(id);
		existingCategory.setName( category.getName());
		existingCategory.setDescription( category.getDescription());
		return saveCategory(existingCategory);
	}

	@Override
	public void deleteCategory(long id) {
		Category existingCategory = getCategoryById(id);
		  if (categoryRepository.isCategoryInUse(id)) {
		        throw new IllegalStateException("Cannot delete category with ID " + id + " because it is being used by a product.");
		    }
		categoryRepository.delete(existingCategory);		
	}

}

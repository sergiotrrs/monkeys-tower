package com.mkstower.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.Category;
import com.mkstower.repository.CategoryRepository;
import com.mkstower.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository userRepository;

	@Override
	public Category createCategory(Category user) {		
		return userRepository.save(user);
	}

	@Override
	public Category getCategoryById(long id) {
		return userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("Category does not exist with id: " + id));		
	}

	@Override
	public List<Category> getAllCategories() {
		return userRepository.findAll();
	}

	@Override
	public List<Category> getAllActiveCategories() {
		// return userRepository.findAll();
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(99, "Electrónico", "Producto electrónico", null));
		return categories;
	}

	@Override
	public Category updateCategory(Category user, long id) {
		Category existingCategory = getCategoryById(id);
		existingCategory.setName( user.getName());

		return createCategory(existingCategory);
	}

	@Override
	public void deleteCategory(long id) {
		Category existingCategory = getCategoryById(id);
		userRepository.delete(existingCategory);		
	}

}

package com.mkstower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.entity.Category;
import com.mkstower.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) {
		Category savedCategory = categoryService.createCategory(category);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
		Category category = categoryService.getCategoryById(id);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategorys() {
		List<Category> categorys = categoryService.getAllCategories();
		return new ResponseEntity<>(categorys, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable long id, @Validated @RequestBody Category category) {
		Category updateCategory = categoryService.updateCategory(category, id);
		return new ResponseEntity<>(updateCategory, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<>("Category id " + id + " successfully deleted", HttpStatus.OK);
	}

}

package com.fooddeliverysystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddeliverysystem.model.Category;

@Service
public interface CategoryService {
	public Category addCategory(Category cat);
	public Category updateCategory(Category cat,Long id);
	public ResponseEntity<Category> removeCategory(Long id);
	public Category viewCategoryById(Long id);
	public List<Category> viewAllCategories();

}

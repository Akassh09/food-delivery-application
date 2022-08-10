package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.dao.CategoryRepository;
import com.cg.exception.CategoryNotFoundException;
import com.cg.model.Category;
import com.cg.service.CategoryServiceImpl;

@Service
public class CategoryService implements CategoryServiceImpl{
	@Autowired
	private CategoryRepository catRepository;

	@Override
	public Category addCategory(Category cat) {
		// TODO Auto-generated method stub
		return catRepository.save(cat);
	}

	@Override
	public Category updateCategory(Category cat, Long id) {
		// TODO Auto-generated method stub
		Category c=new Category();
		try {
			c = (Category) catRepository.findById(id)
					 .orElseThrow(()-> new CategoryNotFoundException("The category not found"));
		} catch (CategoryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setCatName(cat.getCatName());
		return catRepository.save(c);
	}

	@Override
	public ResponseEntity<Category> removeCategory(Long id) {
		// TODO Auto-generated method stub
		Category c=new Category();
		try {
			c = (Category) catRepository.findById(id)
					 .orElseThrow(()-> new CategoryNotFoundException("The category not found"));
		} catch (CategoryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catRepository.delete(c);
		return ResponseEntity.ok().build();
	}

	@Override
	public Category viewCategoryById(Long id) {
		// TODO Auto-generated method stub
		Category c=new Category();
		try {
			c = (Category) catRepository.findById(id)
					 .orElseThrow(()-> new CategoryNotFoundException("The category not found"));
		} catch (CategoryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Category> viewAllCategories() {
		// TODO Auto-generated method stub
		return catRepository.findAll();
	}


}

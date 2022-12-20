package com.shop.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Category;
import com.shop.repo.CategoryRepository;
import com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryid) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryid).get();
	}

	@Override
	public void deleteCategory(long categoryid) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setId(categoryid);
		this.categoryRepository.delete(category);
		
	}

}

package com.shop.service;

import java.util.Set;

import com.shop.entity.Category;

public interface CategoryService {
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();//for fetching all categories
	public Category getCategory(Long categoryid);//for fetching single category
	public void deleteCategory(long categoryid);
}

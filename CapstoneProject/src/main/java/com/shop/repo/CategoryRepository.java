package com.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}

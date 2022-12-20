package com.shop.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Cart;
import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.entity.Wishlist;
import com.shop.repo.ProductRepository;
import com.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productRepository.save(product);
	}

	@Override
	public Set<Product> getProducts() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.productRepository.findAll());
	}

	@Override
	public Product getProduct(Long productId) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(productId).get();
	}

	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		
		this.productRepository.deleteById(productId);
		
	}

//	@Override
//	public Set<Product> getProductsOfCart(Cart cart) {
//		// TODO Auto-generated method stub
//		return this.productRepository.findByCart(cart);
//	}
//
//	@Override
//	public Set<Product> getProductsOfWishlist(Wishlist wishlist) {
//		// TODO Auto-generated method stub
//		return this.productRepository.findByWishlist(wishlist);
//	}

	@Override
	public Set<Product> getProductOfCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}

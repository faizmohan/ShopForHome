package com.shop.service;

import java.util.Set;

import com.shop.entity.Cart;
import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.entity.Wishlist;

public interface ProductService {
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Set<Product> getProducts();
	public Product getProduct(Long productId);
	public void deleteProduct(Long productId);
//	public Set<Product> getProductsOfCart (Cart cart);
//	public Set<Product> getProductsOfWishlist (Wishlist wishlist);
	public Set<Product> getProductOfCategory(Category category);
}

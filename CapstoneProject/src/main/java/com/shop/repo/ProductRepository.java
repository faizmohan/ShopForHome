package com.shop.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.entity.Wishlist;

public interface ProductRepository extends JpaRepository<Product, Long>{

//	Set<Product> findByCart(Cart cart);
//
//	Set<Product> findByWishlist(Wishlist wishlist);

}

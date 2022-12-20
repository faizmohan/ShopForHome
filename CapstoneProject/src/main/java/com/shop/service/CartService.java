package com.shop.service;

import java.util.Set;

import com.shop.entity.Cart;
import com.shop.entity.User;

public interface CartService {
	public Cart addCart(Cart cart);
	public Cart updateCart(Cart cart);
	public Set<Cart> getCarts();
	public Cart getCart(Long cartid);
	public void deleteCart(Long cartid);
	public Set<User> getCartOfUser(User user);
}

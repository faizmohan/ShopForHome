package com.shop.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Cart;
import com.shop.entity.User;
import com.shop.repo.CartRepository;
import com.shop.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return this.cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return this.cartRepository.save(cart);
	}

	@Override
	public Set<Cart> getCarts() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.cartRepository.findAll());
	}

	@Override
	public Cart getCart(Long cartid) {
		// TODO Auto-generated method stub
		return this.cartRepository.findById(cartid).get();
	}

	@Override
	public void deleteCart(Long cartid) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setCartid(cartid);
		this.cartRepository.delete(cart);
		
	}

	@Override
	public Set<User> getCartOfUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.shop.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.entity.Wishlist;
import com.shop.repo.WishlistRepository;
import com.shop.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Override
	public Wishlist addWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
		return this.wishlistRepository.save(wishlist);
	}

	@Override
	public Wishlist updateWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
		return this.wishlistRepository.save(wishlist);
	}

	@Override
	public Set<Wishlist> getWishlists() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.wishlistRepository.findAll());
	}

	@Override
	public Wishlist getWishlist(Long wishlistid) {
		// TODO Auto-generated method stub
		return this.wishlistRepository.findById(wishlistid).get();
	}

	@Override
	public void deleteWishlist(Long wishlistid) {
		// TODO Auto-generated method stub
		Wishlist wishlist = new Wishlist();
		wishlist.setWid(wishlistid);
		this.wishlistRepository.delete(wishlist);
		
	}

	@Override
	public Set<User> getWishListOfUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

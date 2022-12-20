package com.shop.service;

import java.util.Set;

import com.shop.entity.User;
import com.shop.entity.Wishlist;

public interface WishlistService {
	public Wishlist addWishlist(Wishlist wishlist);
	public Wishlist updateWishlist(Wishlist wishlist);
	public Set<Wishlist> getWishlists();
	public Wishlist getWishlist(Long wishlistid);
	public void deleteWishlist(Long wishlistid);
	public Set<User> getWishListOfUser(User user);
}

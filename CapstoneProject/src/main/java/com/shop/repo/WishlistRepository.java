package com.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist,Long>{

}

package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Wishlist;
import com.shop.service.ProductService;
import com.shop.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin("*")
public class WishlistController {
	
	@Autowired
	private WishlistService wishlistService;
	
	@Autowired
	private ProductService productService;
	
//	add wishlist
	@PostMapping("/")
	public ResponseEntity<Wishlist> add(@RequestBody Wishlist wishlist)
	{
		return ResponseEntity.ok(this.wishlistService.addWishlist(wishlist));
	}
	
//	update wishlist
	@PutMapping("/")
	public ResponseEntity<Wishlist> update(@RequestBody Wishlist wishlist)
	{
		return ResponseEntity.ok(this.wishlistService.updateWishlist(wishlist));
	}
	
	@PostMapping("/addProduct/{wid}/{pid}")
	Wishlist addProduct(@PathVariable("wid") long wid, @PathVariable("pid") long pid) {
		Wishlist wl = wishlistService.getWishlist(wid);
		wl.getProducts().add(productService.getProduct(pid));
		return wishlistService.addWishlist(wl);
	}
	
//	getting all wishlist
	@GetMapping("/")
	public ResponseEntity<?> getAllWishlist(){
		System.out.println("---------yes");
		return ResponseEntity.ok(this.wishlistService.getWishlists());
	}
	
//	get single wishlist
	@GetMapping("/{wid}")
	public Wishlist getSingleList(@PathVariable("wid") Long wid)
	{
		return this.wishlistService.getWishlist(wid);
	}
	
//	delete wishlist
	@DeleteMapping("/{wid}")
	public void delete(@PathVariable("wid") Long wid)
	{
		this.wishlistService.deleteWishlist(wid);
	}
}

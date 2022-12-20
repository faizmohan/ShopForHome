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
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Cart;
import com.shop.entity.Wishlist;
import com.shop.service.CartService;
import com.shop.service.ProductService;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
//	add cart
	@PostMapping("/")
	public ResponseEntity<Cart> add(@RequestBody Cart cart)
	{
		return ResponseEntity.ok(this.cartService.addCart(cart));
	}
	
//	update cart
	@PutMapping("/")
	public ResponseEntity<Cart> update(@RequestBody Cart cart)
	{
		return ResponseEntity.ok(this.cartService.updateCart(cart));
	}
	
	@PostMapping("/addProduct/{cid}/{pid}")
	Cart addProduct(@PathVariable("cid") long cid, @PathVariable("pid") long pid) {
		Cart cart = cartService.getCart(cid);
		cart.getProducts().add(productService.getProduct(pid));
		return cartService.addCart(cart);
	}
	
//	getting all cart
	@GetMapping("/")
	public ResponseEntity<?> getAllcart(){
		return ResponseEntity.ok(this.cartService.getCarts());
	}
	
//	get single cart
	@GetMapping("/{cartid}")
	public Cart getSingleList(@PathVariable("cartid") Long cartid)
	{
		return this.cartService.getCart(cartid);
	}
	
//	delete cart
	@DeleteMapping("/{cartid}")
	public void delete(@PathVariable("cartid") Long cartid)
	{
		this.cartService.deleteCart(cartid);
	}
}

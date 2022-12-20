package com.shop.controller;


import java.util.Set;

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
import com.shop.entity.Category;
import com.shop.entity.Product;
import com.shop.entity.Wishlist;
import com.shop.service.CartService;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import com.shop.service.WishlistService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private WishlistService wishlistService;

	@Autowired
	private CartService cartService;

	//	add product
	@PostMapping("/")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		return ResponseEntity.ok(this.productService.addProduct(product));
	}

	//	update
	@PutMapping("/")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		return ResponseEntity.ok(this.productService.updateProduct(product));
	}

	//	get all products
	@GetMapping("/")
	public ResponseEntity<?> getAllProducts(){
		return ResponseEntity.ok(this.productService.getProducts());
	}

	//	get product based on category
	@GetMapping("/category/{cid}")
	public ResponseEntity<?> getProductsOfCategory(@PathVariable("cid") Long cid)
	{
		//		Category category = new Category();
		//		category.setId(cid);
		//		Set<Product> productOfCategory = this.productService.getProductOfCategory(category);
		//		return ResponseEntity.ok(productOfCategory);
		Category category = this.categoryService.getCategory(cid);
		Set<Product> products = category.getProducts();
		return ResponseEntity.ok(products);
	}

	//	get product from wishlist
	@GetMapping("/wishlist/{wid}")
	public ResponseEntity<?> getProductOfWishlist(@PathVariable("wid") Long wid)
	{
		Wishlist wishlist = this.wishlistService.getWishlist(wid);
		Set<Product> products = wishlist.getProducts();
		return ResponseEntity.ok(products);
	}

	//	get product from cart
	@GetMapping("/cart/{cartid}")
	public ResponseEntity<?> getProductOfCart(@PathVariable("cartid") Long cartid)
	{
		Cart cart = this.cartService.getCart(cartid);
		Set<Product> products = cart.getProducts();
		return ResponseEntity.ok(products);
	}

	//	get single product
	@GetMapping("/{proid}")
	public Product getSingleProduct(@PathVariable("proid") Long proid)
	{
		return this.productService.getProduct(proid);
	}

	//	delete
	@DeleteMapping("/{proid}")
	public void delete(@PathVariable("proid") Long proid)
	{
		this.productService.deleteProduct(proid);
	}
}

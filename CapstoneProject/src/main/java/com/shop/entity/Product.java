package com.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pid;
	
	private String productName;
	private String productDesc;
	private double productPrice;
	private double productCount;
	@Column(length = 5000)
	private String image;
	private boolean active =false;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Category category;
	
//	@ManyToMany()
//	private Wishlist wishlist;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Cart cart;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productName, String productDesc, double productPrice, double productCount, String image,
			boolean active) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.image = image;
		this.active = active;
	}

	
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
//	public Wishlist getWishlist() {
//		return wishlist;
//	}
//	public void setWishlist(Wishlist wishlist) {
//		this.wishlist = wishlist;
//	}
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getProductCount() {
		return productCount;
	}
	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}

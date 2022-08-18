package com.fooddeliverysystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Checkout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long checkoutId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurantId")
	@JsonBackReference
	private Restaurant res;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	@JsonBackReference
	private Customer cust;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "itemId")
	@JsonBackReference
	private Item item;
	
	private String payment;
	
	public Checkout() {
		super();
	}

	

	public Checkout(long checkoutId, Restaurant res, Customer cust, Item item, String payment) {
		super();
		this.checkoutId = checkoutId;
		this.res = res;
		this.cust = cust;
		this.item = item;
		this.payment = payment;
	}



	public long getCheckoutId() {
		return checkoutId;
	}



	public void setCheckoutId(long checkoutId) {
		this.checkoutId = checkoutId;
	}



	public Restaurant getRes() {
		return res;
	}



	public void setRes(Restaurant res) {
		this.res = res;
	}



	public Customer getCust() {
		return cust;
	}



	public void setCust(Customer cust) {
		this.cust = cust;
	}



	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	public String getPayment() {
		return payment;
	}



	public void setPayment(String payment) {
		this.payment = payment;
	}


   
	
	
}

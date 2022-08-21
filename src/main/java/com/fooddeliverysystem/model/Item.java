package com.fooddeliverysystem.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String itemName;
	private int quantity;
	private double cost;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurantId")
	@JsonBackReference
	private Restaurant res;

//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="cartId",referencedColumnName="id")
//	private FoodCart foodcart;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Long itemId, String itemName, int quantity, double cost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.cost = cost;
//		this.foodcart=foodcart;
	}

//	public FoodCart getFoodcart() {
//		return foodcart;
//	}
//	public void setFoodcart(FoodCart foodcart) {
//		this.foodcart = foodcart;
//	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	

	

}
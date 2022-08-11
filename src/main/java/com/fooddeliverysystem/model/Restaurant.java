package com.fooddeliverysystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long restaurantId;
    private String restaurantName;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="addressId")
    @JsonManagedReference
    @JsonIgnore
    private Address address;
    private String managerName;
    private String res_pincode;
    private String contactNumber;
    @OneToMany(mappedBy = "res", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Item> itemList;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(Long restaurantId, String restaurantName, Address address, String managerName, String res_pincode,
			String contactNumber, List<Item> itemList) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.managerName = managerName;
		this.res_pincode = res_pincode;
		this.contactNumber = contactNumber;
		this.itemList = itemList;
	}

	@JsonManagedReference
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getResPincode() {
		return res_pincode;
	}

	public void setResPincode(String res_pincode) {
		this.res_pincode = res_pincode;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	

}






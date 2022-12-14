package com.fooddeliverysystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddeliverysystem.dao.RestaurantRepository;
import com.fooddeliverysystem.exception.RestaurantNotFoundException;
import com.fooddeliverysystem.model.Item;
import com.fooddeliverysystem.model.Restaurant;
import com.fooddeliverysystem.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	@Autowired
	private RestaurantRepository resRepository;

	@Override
	public Restaurant addRestaurant(Restaurant res) {
		// TODO Auto-generated method stub
		return resRepository.save(res);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res, Long id) {
		// TODO Auto-generated method stub
		Restaurant resItem=new Restaurant();
		try {
			resItem = (Restaurant) resRepository.findById(id)
					 .orElseThrow(()-> new RestaurantNotFoundException("The restaurant not found"));
		} catch (RestaurantNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resItem.setAddress(res.getAddress());
		resItem.setContactNumber(res.getContactNumber());
		resItem.setManagerName(res.getManagerName());
		resItem.setRestaurantName(res.getRestaurantName());
		return resRepository.save(resItem);
	}

	@Override
	public ResponseEntity<Restaurant> removeRestaurant(Long id) {
		Restaurant resItem=new Restaurant();
		try {
			resItem = (Restaurant) resRepository.findById(id)
					 .orElseThrow(()-> new RestaurantNotFoundException("The restaurant not found"));
		} catch (RestaurantNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resRepository.delete(resItem);
		return ResponseEntity.ok().build();
		
	}

	@Override
	public Restaurant viewRestaurantsById(Long id) {
		Restaurant resItem=new Restaurant();
		try {
			resItem = (Restaurant) resRepository.findById(id)
					 .orElseThrow(()-> new RestaurantNotFoundException("The restaurant not found"));
		} catch (RestaurantNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resItem;	
	}

	@Override
	public List<Restaurant> viewAllRestaurants() {
		// TODO Auto-generated method stub
		return resRepository.findAll();
	}

	@Override
	public List<Restaurant> viewRestaurantByItem(String itemName) {
		List<Restaurant> res=new ArrayList<Restaurant>();
		List<Restaurant> r=resRepository.findAll();
	
		for(Restaurant item:r) {
			List<Item> i=item.getItemList();
			for(Item items:i) {
				if(items.getItemName().equals(itemName))
					res.add(item);
			}
			
		}
		try {
			if(res.size()==0) {
				throw new RestaurantNotFoundException("No Restaurant Found");
			}
		}catch(RestaurantNotFoundException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public List<Restaurant> RestaurantByPincode(String res_pincode) {
		// TODO Auto-generated method stub
		return resRepository.findByPincode(res_pincode);
	}

	@Override
	public Restaurant reslogin(String restaurantName, String password) {
		// TODO Auto-generated method stub
		return resRepository.findByUserPassword(restaurantName, password);
	}
	

}

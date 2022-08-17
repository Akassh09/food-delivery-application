package com.fooddeliverysystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddeliverysystem.model.Customer;
import com.fooddeliverysystem.model.Restaurant;

@Service
public interface RestaurantService {
      public Restaurant addRestaurant(Restaurant res);
      public Restaurant updateRestaurant(Restaurant res,Long id);
      public ResponseEntity<Restaurant> removeRestaurant(Long id);
      public Restaurant viewRestaurantsById(Long id);
      public List<Restaurant> viewAllRestaurants();
      public List<Restaurant> viewRestaurantByItem(String itemName);
	  Restaurant reslogin(String restaurantName, String password);
}

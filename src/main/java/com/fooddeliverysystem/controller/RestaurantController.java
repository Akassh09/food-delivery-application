package com.fooddeliverysystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.fooddeliverysystem.dao.RestaurantRepository;
import com.fooddeliverysystem.model.Customer;
import com.fooddeliverysystem.model.Restaurant;
import com.fooddeliverysystem.service.RestaurantServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class RestaurantController {
	@Autowired
	private RestaurantServiceImpl resService;
	
	@Autowired
	private RestaurantRepository respo;
	
	
	@PostMapping("/restaurants")
	public Restaurant addRestaurant(@RequestBody Restaurant res) {
		return resService.addRestaurant(res);
	}
	@PutMapping("/restaurants/{id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant res,@PathVariable Long id) {
		return resService.updateRestaurant(res, id);
	}
	@DeleteMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> removeRestaurant(@PathVariable Long id) {
		return resService.removeRestaurant(id);
	}
    
	@GetMapping("getrestaurant/{id}")
	public Restaurant getRestaurantDetails(@PathVariable("id") long id) {
		Optional<Restaurant> op=respo.findById(id);
		if(op.isPresent()) {
			Restaurant res=op.get();
			return res;
		}
		else {
			return null;
		}
		
     }
	
	@GetMapping("restaurants")
	public List<Restaurant> viewAllRestaurants(){
		return resService.viewAllRestaurants();
	}
	@GetMapping("restaurants/{itemName}")
	public List<Restaurant> viewRestaurantByItem(@PathVariable String itemName){
		return resService.viewRestaurantByItem(itemName);
	}
	
	@GetMapping("/getrestaurantbypincode/{res_pincode}")
	public List<Restaurant> findRestaurantByPincode(@PathVariable("res_pincode") String res_pincode){
		return  resService.RestaurantByPincode(res_pincode);
    }
	
	@PostMapping("/reslogin/{restaurantName}/{password}")
	public ResponseEntity<Object> Restaurantlogin(@PathVariable("restaurantName") String restaurantName, @PathVariable("password") String password) {
		Restaurant rest=resService.reslogin(restaurantName, password);
		if(rest!=null) {
			System.out.println(rest);
			return new ResponseEntity<Object>(rest, HttpStatus.OK);
		}else {
			System.out.println();
			return new ResponseEntity<Object>("Wrong Restaurant Name or Password", HttpStatus.NOT_FOUND);
		}
		
	}
}
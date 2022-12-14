package com.fooddeliverysystem.controller;

import java.util.List;

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

import com.fooddeliverysystem.dao.CartRepository;
import com.fooddeliverysystem.model.FoodCart;
import com.fooddeliverysystem.model.Item;
import com.fooddeliverysystem.service.CartServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartServiceImpl cService;
    
    @Autowired
    private CartRepository cartrepo;
    
    @PostMapping("/foodcart")
    public FoodCart createCart(@RequestBody FoodCart cart) {
    	return cService.createCart(cart);
    }
    @PutMapping("/foodcart/additem/{id}")
    public FoodCart addItemToCart( @RequestBody Item item,@PathVariable Long id) {
    	return cService.addItemToCart(item, id);
    }
    @PutMapping("/foodcart/increasequantity/{id}")
    public FoodCart increaseQuantity(Item item, int quantity, Long id) {
    	return cService.increaseQuantity(item, quantity, id);
    }
    @PutMapping("foodcart/decreasequantity/{id}")
    public FoodCart decreaseQuantity( Item item, int quantity, Long id) {
    	return cService.decreaseQuantity(item, quantity, id);
    }
    @PutMapping("/foodcart/removeitem/{id}")
    public FoodCart removeItem(Item item, Long id) {
    	return cService.removeItem(item, id);
    }
    @DeleteMapping("/foodcart/{id}")
    public ResponseEntity<FoodCart> clearCart(Long id){
    	return cService.clearCart(id);
    }
    @GetMapping("/foodcart/{id}")
    public FoodCart getFoodCartById(Long id) {
    	return cartrepo.getById(id);
    }
    
    @GetMapping("/foodcart")
    public List<FoodCart> getFoodCart() {
    	return cartrepo.findAll();
    }
}

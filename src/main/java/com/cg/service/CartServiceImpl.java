package com.cg.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.model.FoodCart;
import com.cg.model.Item;

@Service
public interface CartServiceImpl {
    public FoodCart createCart(FoodCart cart);
    public FoodCart addItemToCart(Item item,Long id);
    public FoodCart increaseQuantity(Item item,int quantity,Long id);
    public FoodCart decreaseQuantity(Item item,int quantity,Long id);
    public FoodCart removeItem(Item item,Long id);
    public ResponseEntity<FoodCart> clearCart(Long id);
    public FoodCart getFoodCartById(Long id);

}

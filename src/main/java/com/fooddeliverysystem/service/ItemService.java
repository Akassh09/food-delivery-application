package com.fooddeliverysystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddeliverysystem.model.Item;

@Service
public interface ItemService  {
	public Item addItem(Item item);
	public Item updateItem(Item item,Long id);
	public ResponseEntity<Item> removeItem(Long id);
	public Item viewItemById(Long id);
	public List<Item> viewAllItems();
	public List<Item> viewItemsByRestaurant(String resName);

}
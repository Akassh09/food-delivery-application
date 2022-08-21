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

import com.fooddeliverysystem.dao.ItemRepository;
import com.fooddeliverysystem.model.Item;
import com.fooddeliverysystem.service.ItemServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ItemController {
	@Autowired
	private ItemServiceImpl itemService;
	
	@Autowired
	private ItemRepository itemrepo;
	
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	@PutMapping("/items/{id}")
	public Item updateItem(@RequestBody Item item,@PathVariable Long id) {
		return itemService.updateItem(item, id);
	}
	@DeleteMapping("/items/{id}")
	public ResponseEntity<String> removeItem(@PathVariable Long id){
		itemrepo.deleteById(id);
		return new ResponseEntity<String>("Delete-successfully",HttpStatus.OK);
	}
	
	@GetMapping("getitems/{id}")
	public Item getItemsById(@PathVariable("id") long id) {
		Optional<Item> op=itemrepo.findById(id);
		if(op.isPresent()) {
			Item item=op.get();
			return item;
		}
		else {
			return null;
		}
		
     }
	
	@GetMapping("/items")
	public List<Item> viewAllItems(){
		return itemService.viewAllItems();
	}
	
	@GetMapping("/items/{resName}")
	public List<Item> viewItemsByRestaurant(@PathVariable String resName){
		return itemService.viewItemsByRestaurant(resName);
	}
	
	
}
package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.dao.CartRepository;
import com.cg.exception.FoodCartNotFoundException;
import com.cg.model.FoodCart;
import com.cg.model.Item;
import com.cg.service.ICartService;

@Service
public class CartService implements ICartService {
	@Autowired
	private CartRepository fcRepository;

	@Override
	public FoodCart addItemToCart( Item item,Long id) {
		// TODO Auto-generated method stub
		FoodCart cart=new FoodCart();
		
		try {
			cart = (FoodCart) fcRepository.findById(id)
					 .orElseThrow(()-> new FoodCartNotFoundException("The food cart not found"));
		} catch (FoodCartNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.getItem().add(item);
		return fcRepository.save(cart);
	}

	@Override
	public FoodCart increaseQuantity(Item item, int quantity, Long id) {
		FoodCart cart=new FoodCart(); 
		// TODO Auto-generated method stub
		try {
			cart = (FoodCart) fcRepository.findById(id)
					 .orElseThrow(()-> new FoodCartNotFoundException("The food cart not found"));
		} catch (FoodCartNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for(Item i:cart.getItem()) {
			if(i.getItemId()==item.getItemId()) {
				i.setQuantity(item.getQuantity()+quantity);
			}
		}
		return fcRepository.save(cart);
	}

	@Override
	public FoodCart decreaseQuantity( Item item, int quantity, Long id) {
		FoodCart cart=new FoodCart(); 
		// TODO Auto-generated method stub
		try {
			cart = (FoodCart) fcRepository.findById(id)
					 .orElseThrow(()-> new FoodCartNotFoundException("The food cart not found"));
		} catch (FoodCartNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for(Item i:cart.getItem()) {
			if(i.getItemId()==item.getItemId()) {
				i.setQuantity(item.getQuantity()-quantity);
			}
		}
		return fcRepository.save(cart);
		
	}

	@Override
	public FoodCart removeItem(Item item, Long id) {
		FoodCart cart=new FoodCart(); 
		// TODO Auto-generated method stub
		try {
			cart = (FoodCart) fcRepository.findById(id)
					 .orElseThrow(()-> new FoodCartNotFoundException("The food cart not found"));
		} catch (FoodCartNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.getItem().remove(item);
		return fcRepository.save(cart);
		
	}

	@Override
	public ResponseEntity<FoodCart> clearCart(Long id) {
		// TODO Auto-generated method stub
		FoodCart cart=new FoodCart(); 
		// TODO Auto-generated method stub
		try {
			cart = (FoodCart) fcRepository.findById(id)
					 .orElseThrow(()-> new FoodCartNotFoundException("The food cart not found"));
		} catch (FoodCartNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fcRepository.delete(cart);
		return ResponseEntity.ok().build();
	}

	@Override
	public FoodCart getFoodCartById(Long id) {
		FoodCart cart=new FoodCart(); 
		// TODO Auto-generated method stub
		try {
			cart = (FoodCart) fcRepository.findById(id)
					 .orElseThrow(()-> new FoodCartNotFoundException("The food cart not found"));
		} catch (FoodCartNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}

	@Override
	public FoodCart createCart(FoodCart cart) {
		// TODO Auto-generated method stub
		return fcRepository.save(cart);
	}

}
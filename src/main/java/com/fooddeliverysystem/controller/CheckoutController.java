package com.fooddeliverysystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddeliverysystem.dao.CheckoutRepository;
import com.fooddeliverysystem.model.Checkout;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CheckoutController {
	
	private CheckoutRepository crepo;

	@PostMapping("/checkout")
    public Checkout addCheckout(@RequestBody @Valid Checkout checkout) {
    	return crepo.save(checkout);
    }
	
	@GetMapping("/checkout/{id}")
    public Checkout viewCheckoutById(@PathVariable Long checkoutId) {
    	return crepo.getById(checkoutId);
    }
    
    @GetMapping("/checkout")
    public List<Checkout> viewAllCheckout() {
    	return crepo.findAll();
    }
}

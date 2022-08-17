package com.fooddeliverysystem.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

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

import com.fooddeliverysystem.model.Customer;
import com.fooddeliverysystem.model.Restaurant;
import com.fooddeliverysystem.service.CustomerService;
import com.fooddeliverysystem.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl custService;
    
    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody @Valid Customer customer) {
    	return custService.addCustomer(customer);
    }
    @PutMapping("/updatecustomer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable Long id) {
    	return custService.updateCustomer(customer, id);
    }
    @DeleteMapping("/deletecustomerbyid/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable Long id){
    	return custService.removeCustomer(id);
    }
    @GetMapping("/getcustomerbyid/{id}")
    public Customer viewCustomerById(@PathVariable Long id) {
    	return custService.viewCustomerById(id);
    }
    @GetMapping("/getallcustomers")
    public List<Customer> viewAllCustomers() {
    	return custService.viewAllCustomers();
    }
    
    @PostMapping("/login/{username}/{password}")
	public ResponseEntity<Object> login(@PathVariable("username") String username, @PathVariable("password") String password) {
		Customer cust=custService.login(username, password);
		if(cust!=null) {
			System.out.println(cust);
			return new ResponseEntity<Object>(cust, HttpStatus.OK);
		}else {
			System.out.println();
			return new ResponseEntity<Object>("Wrong UserName Password", HttpStatus.NOT_FOUND);
		}
		
	}
    
}
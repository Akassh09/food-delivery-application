package com.fooddeliverysystem.service;

import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddeliverysystem.model.Customer;

@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer,Long id);
	public ResponseEntity<Customer> removeCustomer(Long id);
	public Customer viewCustomerById(Long id);
	public List<Customer> viewAllCustomers();
	Customer login(String username, String password);

}
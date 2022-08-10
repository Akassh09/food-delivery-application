package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.model.Customer;

@Service
public interface CustomerServiceImpl {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer,Long id);
	public ResponseEntity<Customer> removeCustomer(Long id);
	public Customer viewCustomerById(Long id);
	public List<Customer> viewAllCustomers();

}
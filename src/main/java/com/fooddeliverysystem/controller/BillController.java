package com.fooddeliverysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddeliverysystem.model.Bill;
import com.fooddeliverysystem.service.BillServiceImpl;
@RestController
@RequestMapping("/api/v1")
public class BillController {
	@Autowired
	private BillServiceImpl bService;
	@PostMapping("/bills")
	public Bill addBill(@RequestBody Bill bill) {
		return bService.addBill(bill);
	}
	@PutMapping("/bills/{id}")
	public Bill updateBill(@RequestBody Bill bill,@PathVariable Long id) {
		return bService.updateBill(bill, id);
	}
	@DeleteMapping("/bills/{id}")
	public ResponseEntity<Bill> removeBill(@PathVariable Long id){
		return bService.removeBill(id);
	}
	@GetMapping("/bills/{id}")
	public Bill viewBillsById(@PathVariable Long id) {
		return bService.viewBillsById(id);
	}
	@GetMapping("/bills")
	public List<Bill> viewAllBills(){
		return bService.viewAllBills();
	}

}
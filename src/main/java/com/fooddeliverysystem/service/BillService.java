package com.fooddeliverysystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddeliverysystem.model.Bill;

@Service
public interface BillService {
	public Bill addBill(Bill bill);
	public Bill updateBill(Bill bill,Long id);
	public ResponseEntity<Bill> removeBill(Long id);
	public Bill viewBillsById(Long id);
	public List<Bill> viewAllBills();

}
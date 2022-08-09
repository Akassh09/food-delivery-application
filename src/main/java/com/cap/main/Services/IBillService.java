package com.cap.main.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cap.main.Model.Bill;

@Service
public interface IBillService {
	public Bill addBill(Bill bill);
	public Bill updateBill(Bill bill,Long id);
	public ResponseEntity<Bill> removeBill(Long id);
	public Bill viewBillsById(Long id);
	public List<Bill> viewAllBills();

}
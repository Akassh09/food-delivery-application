package com.cg.controller;

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

import com.cg.model.OrderDetails;
import com.cg.service.OrderService;


	@RestController
	@RequestMapping("/api/v1")
	public class OrderController {
		@Autowired
		private OrderService oService;
		@PostMapping("/orders")
		public OrderDetails addOrder(@RequestBody OrderDetails order) {
			return oService.addOrder(order);
		}
		@PutMapping("/order/{id}")
		public OrderDetails updateOrder(@RequestBody OrderDetails od, @PathVariable Long id) {
			return oService.updateOrder(od, id);
		}
		@DeleteMapping("/orders/{id}")
		public ResponseEntity<OrderDetails> removeOrder(@PathVariable Long id){
			return oService.removeOrder(id);
		}
		@GetMapping("/orders/{id}")
		public OrderDetails viewOrderById( @PathVariable Long id) {
			return oService.viewOrderById(id);
		}
		@GetMapping("/orders")
		public List<OrderDetails> viewAllOrders(){
			return oService.viewAllOrders();
		}
		

}



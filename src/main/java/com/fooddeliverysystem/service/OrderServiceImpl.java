package com.fooddeliverysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddeliverysystem.dao.OrderRepository;
import com.fooddeliverysystem.exception.OrderNotFoundException;
import com.fooddeliverysystem.model.OrderDetails;
import com.fooddeliverysystem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired 
	private OrderRepository odRepository;

	@Override
	public OrderDetails addOrder(OrderDetails od) {
		// TODO Auto-generated method stub
		return odRepository.save(od);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails od, Long id) {
		// TODO Auto-generated method stub
		OrderDetails order=new OrderDetails();
		try {
			order = (OrderDetails) odRepository.findById(id)
					 .orElseThrow(()-> new OrderNotFoundException("The order not found"));
		} catch (OrderNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		order.setCart(od.getCart());
		order.setOrderDate(od.getOrderDate());
		order.setOrderStatus(od.getOrderStatus());
		return odRepository.save(order);
	}

	@Override
	public ResponseEntity<OrderDetails> removeOrder( Long id) {
		// TODO Auto-generated method stub
		OrderDetails order=new OrderDetails();
		try {
			order = (OrderDetails) odRepository.findById(id)
					 .orElseThrow(()-> new OrderNotFoundException("The order not found"));
		} catch (OrderNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		odRepository.delete(order);
		return ResponseEntity.ok().build();
		
	}

	@Override
	public OrderDetails viewOrderById( Long id) {
		// TODO Auto-generated method stub
		OrderDetails order=new OrderDetails();
		try {
			order = (OrderDetails) odRepository.findById(id)
					 .orElseThrow(()-> new OrderNotFoundException("The order not found"));
		} catch (OrderNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<OrderDetails> viewAllOrders() {
		// TODO Auto-generated method stub
		return odRepository.findAll(); 
		
	}
	

}

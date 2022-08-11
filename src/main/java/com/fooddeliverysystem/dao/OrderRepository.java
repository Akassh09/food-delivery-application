package com.fooddeliverysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddeliverysystem.model.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Long> {

}

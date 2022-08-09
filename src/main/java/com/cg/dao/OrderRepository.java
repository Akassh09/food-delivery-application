package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Long> {

}

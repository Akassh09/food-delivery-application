package com.fooddeliverysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddeliverysystem.model.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout,Long>{

}

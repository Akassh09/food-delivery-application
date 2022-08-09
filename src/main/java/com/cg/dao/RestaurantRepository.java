package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}

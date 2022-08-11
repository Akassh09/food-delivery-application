package com.fooddeliverysystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.fooddeliverysystem.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

	
	@Query(value = "select p from Restaurant p where p.res_pincode=:res_pincode")
	List<Restaurant> findByPincode(@Param("res_pincode") String res_pincode);

}

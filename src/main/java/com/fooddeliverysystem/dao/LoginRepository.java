package com.fooddeliverysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddeliverysystem.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login , Long>{
	

}

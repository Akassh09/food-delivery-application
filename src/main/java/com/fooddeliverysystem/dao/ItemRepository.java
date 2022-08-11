package com.fooddeliverysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddeliverysystem.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {


}

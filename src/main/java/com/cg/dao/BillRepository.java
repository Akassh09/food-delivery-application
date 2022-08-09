package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

}

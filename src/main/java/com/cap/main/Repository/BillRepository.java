package com.cap.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.main.Model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

}

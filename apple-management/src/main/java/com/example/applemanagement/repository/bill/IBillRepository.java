package com.example.applemanagement.repository.bill;

import com.example.applemanagement.model.billDetail.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill,Integer> {
}

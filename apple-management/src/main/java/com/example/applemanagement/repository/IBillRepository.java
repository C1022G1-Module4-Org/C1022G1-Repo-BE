package com.example.applemanagement.repository;

import com.example.applemanagement.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "select * from bill where code like %:code% and is_delete = false",nativeQuery = true)
        Page<Bill> findByCodeAnd(Pageable pageable,@Param("code") String code);
}

package com.example.applemanagement.repository;

import com.example.applemanagement.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByCustomer(String name);

}

package com.example.applemanagement.repository.customer;

import com.example.applemanagement.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByCustomer(String name);

    Page<Customer> findCustomerByCustomerContaining( String name, Pageable pageable);


}

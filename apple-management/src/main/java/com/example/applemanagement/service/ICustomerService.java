package com.example.applemanagement.service;


import com.example.applemanagement.dto.customerDTO.CustomerDTO;
import com.example.applemanagement.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {
    Page<CustomerDTO> findAll(String name , Pageable pageable);
    Customer findById(long id);
    Customer findByCustomer(String name);
    void create(Customer customer);
    void delete(Customer customer);
    void save(Customer customer);
}

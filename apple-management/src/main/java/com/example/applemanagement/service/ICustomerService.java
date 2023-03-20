package com.example.applemanagement.service;


import com.example.applemanagement.model.customer.Customer;

import java.util.List;


public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(long id);
    Customer findByCustomer(String name);
    void create(Customer customer);
    void delete(Customer customer);

}

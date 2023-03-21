package com.example.applemanagement.service.impl;


import com.example.applemanagement.model.customer.Customer;
import com.example.applemanagement.repository.ICustomerRepository;
import com.example.applemanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public Customer findByCustomer(String name) {
        return iCustomerRepository.findByCustomer(name);
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }


}

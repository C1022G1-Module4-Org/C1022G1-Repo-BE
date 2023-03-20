package com.example.applemanagement.service;

import com.example.applemanagement.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    CustomerType findById(long id);

    List<CustomerType> findAllCustomerType();
}

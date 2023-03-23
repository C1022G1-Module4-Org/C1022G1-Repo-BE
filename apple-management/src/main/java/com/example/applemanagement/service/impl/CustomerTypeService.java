package com.example.applemanagement.service.impl;

import com.example.applemanagement.model.customer.CustomerType;
import com.example.applemanagement.repository.customer.ICustomerTypeRepository;
import com.example.applemanagement.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public CustomerType findById(long id) {
        return iCustomerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return iCustomerTypeRepository.findAll();
    }
}

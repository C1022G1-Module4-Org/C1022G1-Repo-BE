package com.example.applemanagement.service.impl;


import com.example.applemanagement.dto.customerDTO.CustomerDTO;
import com.example.applemanagement.model.customer.Customer;
import com.example.applemanagement.model.customer.CustomerType;
import com.example.applemanagement.repository.customer.ICustomerRepository;
import com.example.applemanagement.service.ICustomerService;
import com.example.applemanagement.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private ICustomerTypeService customerTypeService;


    @Override
    public Page<CustomerDTO> findAll(String name , Pageable pageable ) {
        Page<Customer> customerPage = iCustomerRepository.findCustomerByCustomerContaining(name, pageable);
        List<CustomerDTO> customerList = new ArrayList<>();
        CustomerDTO customerDTO;
        for (Customer customer : customerPage) {
            customerDTO = new CustomerDTO();
            customer.setCustomerType(customerTypeService.findById(customer.getCustomerType().getId().intValue()));
            customerDTO.setCustomerType(new CustomerType());
            BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerType());
            BeanUtils.copyProperties(customer, customerDTO);
            customerList.add(customerDTO);
        }
        return new PageImpl<>(customerList, pageable, customerPage.getTotalElements());

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

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }


}

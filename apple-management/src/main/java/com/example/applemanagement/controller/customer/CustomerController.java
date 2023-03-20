package com.example.applemanagement.controller.customer;


import com.example.applemanagement.dto.customerDTO.CustomerDTO;
import com.example.applemanagement.model.customer.Customer;
import com.example.applemanagement.model.customer.CustomerType;
import com.example.applemanagement.service.impl.CustomerService;
import com.example.applemanagement.service.impl.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;
    @GetMapping("")
    List<Customer> showList() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    Customer showById(@PathVariable int id) {
        return customerService.findById(id);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
         customerService.delete(showById(id));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void create( @RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customer.setCustomerType(customerTypeService.findById(customer.getCustomerType().getId().intValue()));
        customerService.create(customer);
    }
    @GetMapping("/customerType")
    List<CustomerType> findAllCustomer() {
        return customerTypeService.findAllCustomerType();
    }

    @PostMapping("/{id}")
    void edit (@RequestBody CustomerDTO customerDTO , int id) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customer.setCustomerType(customerTypeService.findById(customer.getCustomerType().getId().intValue()));

    }


}

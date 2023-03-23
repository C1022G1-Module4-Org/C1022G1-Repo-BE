package com.example.applemanagement.controller.customer;


import com.example.applemanagement.dto.customerDTO.CustomerDTO;
import com.example.applemanagement.model.customer.Customer;
import com.example.applemanagement.model.customer.CustomerType;
import com.example.applemanagement.service.impl.CustomerService;
import com.example.applemanagement.service.impl.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;
    @GetMapping("")
    Page<CustomerDTO> showList(
                             @PageableDefault(size = 3) Pageable pageable,
                             @RequestParam(name = "name",required = false, defaultValue = "") String name) {
        return customerService.findAll(name , pageable);
    }

    @GetMapping("/{id}")
    Customer showById(@PathVariable int id) {
        return customerService.findById(id);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
         customerService.delete(showById(id));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> create(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO,customer);
            customer.setCustomerType(customerTypeService.findById(customer.getCustomerType().getId().intValue()));
            customerService.create(customer);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);


    }
    @GetMapping("/customerType")
    @ResponseStatus(HttpStatus.OK)

    List<CustomerType> findAllCustomer() {
        return customerTypeService.findAllCustomerType();
    }

    @PostMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> edit ( @Validated @RequestBody CustomerDTO customerDTO , @PathVariable int id, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Customer customer = customerService.findById(id);
            BeanUtils.copyProperties(customerDTO,customer);
            customer.setCustomerType(customerTypeService.findById(customer.getCustomerType().getId().intValue()));
            customerService.save(customer);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    }




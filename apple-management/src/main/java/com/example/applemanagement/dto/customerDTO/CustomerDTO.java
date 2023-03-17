package com.example.applemanagement.dto.customerDTO;

import com.example.applemanagement.model.customer.CustomerType;
import com.sun.istack.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CustomerDTO implements Validator {
    private long id;
    private String customer;

//    @NotNull
//    @NotBlank
//    @Size(max = 50)
    private String dateOfBirth;
//    @NotNull
//    @NotBlank
//    @Size(max = 250)
    private String img;

    private CustomerType customerType;

    public CustomerDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;

        String name = customerDTO.getCustomer();
        String dateOfBirth = customerDTO.getDateOfBirth();
        String img = customerDTO.getImg();;
        CustomerType customerType1 = customerDTO.getCustomerType();
    }
}

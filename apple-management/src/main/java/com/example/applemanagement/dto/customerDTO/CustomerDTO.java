package com.example.applemanagement.dto.customerDTO;

import com.example.applemanagement.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO implements Validator {
    private long id;

    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "Please fill in the correct format: Nguyen Van A")
    private String customer;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$" , message = "Please fill in the correct format: 01/01/2000")
    private String dateOfBirth;
    @NotBlank
    private String address;
    @Pattern(regexp = "\\b\\d{12}\\b" , message = "Please fill in the correct format: 004002412585")
    private String idCard;
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$", message = "Số điện thoại phải theo dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;

        String name = customerDTO.getCustomer();
        String dateOfBirth = customerDTO.getDateOfBirth();
        String address = customerDTO.getAddress();
        String idCard = customerDTO.getIdCard();
        String phoneNumber = customerDTO.getPhoneNumber();
        CustomerType customerType1 = customerDTO.getCustomerType();
    }
}

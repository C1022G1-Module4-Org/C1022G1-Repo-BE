package com.example.applemanagement.model.customer;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customer;
    private String dateOfBirth;
    private String img;

    @ManyToOne
    @JoinColumn(name = "customerTypeId", referencedColumnName = "id")
    @JsonManagedReference
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(long id, String customer, String dateOfBirth, String img, CustomerType customerType) {
        this.id = id;
        this.customer = customer;
        this.dateOfBirth = dateOfBirth;
        this.img = img;
        this.customerType = customerType;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}

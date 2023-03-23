package com.example.applemanagement.model.customer;


import com.example.applemanagement.model.billDetail.Bill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customer;
    private String dateOfBirth;
    private String address;
    private String idCard;
    private String phoneNumber;
    private String img;

    @ManyToOne
    @JoinColumn(name = "customerTypeId", referencedColumnName = "id")
    @JsonManagedReference
    private CustomerType customerType;



    @OneToMany(mappedBy = "customerId" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Bill> billSet;

    public Customer() {
    }

    public Customer(String customer, String dateOfBirth, String address, String idCard, String phoneNumber, String img, CustomerType customerType) {
        this.customer = customer;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.customerType = customerType;
    }

    public Customer(long id, String customer, String dateOfBirth, String address, String idCard, String phoneNumber, String img, CustomerType customerType) {
        this.id = id;
        this.customer = customer;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.customerType = customerType;
    }

    public Customer(long id, String customer, String dateOfBirth, String address, String idCard, String phoneNumber, String img, CustomerType customerType, Set<Bill> billSet) {
        this.id = id;
        this.customer = customer;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.customerType = customerType;
        this.billSet = billSet;
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

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }
}

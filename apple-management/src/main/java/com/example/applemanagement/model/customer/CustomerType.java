package com.example.applemanagement.model.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Customer> customerSet;

    public CustomerType() {
    }

    public CustomerType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerType(Long id, String name, Set<Customer> customerSet) {
        this.id = id;
        this.name = name;
        this.customerSet = customerSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}

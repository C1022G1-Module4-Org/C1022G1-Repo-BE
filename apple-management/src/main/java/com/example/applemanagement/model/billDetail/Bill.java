package com.example.applemanagement.model.billDetail;

import com.example.applemanagement.model.customer.Customer;
import com.example.applemanagement.model.employee.Employee;
import com.example.applemanagement.model.store.Store;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer billDetailId;
    private String date;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    @JsonManagedReference
    private Customer customerId;
    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    @JsonManagedReference
    private Employee employeeId;
    @ManyToOne
    @JoinColumn(name = "storeId", referencedColumnName = "id")
    @JsonManagedReference
    private Store storeId;

    public Bill() {
    }

    public Bill(Integer id, Integer billDetailId, String date, Customer customerId, Employee employeeId, Store storeId) {
        this.id = id;
        this.billDetailId = billDetailId;
        this.date = date;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.storeId = storeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(Integer billDetailId) {
        this.billDetailId = billDetailId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }
}

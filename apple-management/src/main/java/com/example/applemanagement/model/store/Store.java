package com.example.applemanagement.model.store;

import com.example.applemanagement.model.billDetail.Bill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String email;
    private String phone;
    private boolean isDelete = false;
    @OneToMany(mappedBy = "storeId" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Bill> billSet;
    @ManyToOne
    @JoinColumn(name = "store_type", nullable = false, referencedColumnName = "idType")
    @JsonBackReference
    private StoreType storeType;

    public Store() {
    }

    public Store(Integer id, String name, String address, String city, String email, String phone, boolean isDelete, Set<Bill> billSet, StoreType storeType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.isDelete = isDelete;
        this.billSet = billSet;
        this.storeType = storeType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType;
    }

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }
}

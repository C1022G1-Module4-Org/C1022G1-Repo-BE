package com.example.applemanagement.dto.storeDTO;

import com.example.applemanagement.model.store.StoreType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class StoreCreateAndUpdateDTO {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String email;
    private String phone;
    private StoreTypeDTO storeTypeDTO;

    public StoreCreateAndUpdateDTO() {
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

    public StoreTypeDTO getStoreTypeDTO() {
        return storeTypeDTO;
    }

    public void setStoreTypeDTO(StoreTypeDTO storeTypeDTO) {
        this.storeTypeDTO = storeTypeDTO;
    }
}

package com.example.applemanagement.dto.storeDTO;

import com.example.applemanagement.model.store.StoreType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class StoreCreateAndUpdateDTO {
    private Integer id;
    @NotBlank(message = "{notBlank}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{pattern}")
    private String name;
    @NotBlank(message = "{notBlank}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{pattern}")
    private String address;
    @NotBlank(message = "{notBlank}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{pattern}")
    private String city;
    @NotBlank(message = "{notBlank}")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please fill in the correct format: example123@gmail.com")
    private String email;
    @NotBlank(message = "{notBlank}")
    @Pattern(regexp = "^0\\d{9,10}$", message = "Please fill in the correct format: 0-XXXX-XXXXX (X = 0-9)")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{pattern}")
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

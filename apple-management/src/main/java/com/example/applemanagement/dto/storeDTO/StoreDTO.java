package com.example.applemanagement.dto.storeDTO;

public class StoreDTO {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private StoreTypeDTO storeTypeDTO;

    public StoreTypeDTO getStoreTypeDTO() {
        return storeTypeDTO;
    }

    public void setStoreTypeDTO(StoreTypeDTO storeTypeDTO) {
        this.storeTypeDTO = storeTypeDTO;
    }

    public StoreDTO() {
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
}

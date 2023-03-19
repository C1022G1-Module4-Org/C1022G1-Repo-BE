package com.example.applemanagement.dto.storeDTO;

import com.example.applemanagement.model.store.Store;

import java.util.Set;

public class StoreTypeDTO {
    private Integer idType;
    private String type;
    private Set<StoreCreateAndUpdateDTO> storeCreateAndUpdateDTOSet;

    public Set<StoreCreateAndUpdateDTO> getStoreCreateAndUpdateDTOSet() {
        return storeCreateAndUpdateDTOSet;
    }

    public void setStoreCreateAndUpdateDTOSet(Set<StoreCreateAndUpdateDTO> storeCreateAndUpdateDTOSet) {
        this.storeCreateAndUpdateDTOSet = storeCreateAndUpdateDTOSet;
    }

    public StoreTypeDTO() {
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

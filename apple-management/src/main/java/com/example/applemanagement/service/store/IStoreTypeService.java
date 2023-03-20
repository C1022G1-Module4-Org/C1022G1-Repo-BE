package com.example.applemanagement.service.store;

import com.example.applemanagement.dto.storeDTO.StoreTypeDTO;
import com.example.applemanagement.model.store.StoreType;

import java.util.List;

public interface IStoreTypeService {
    StoreType findById(int id);
    List<StoreTypeDTO> listAll();
}

package com.example.applemanagement.service.store;

import com.example.applemanagement.dto.storeDTO.StoreCreateAndUpdateDTO;
import com.example.applemanagement.dto.storeDTO.StoreDTO;
import com.example.applemanagement.model.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStoreService {
    Page<StoreDTO> listAll(Pageable pageable, String name);

    Store findById(int id);

    void delete(int id);
    void create(StoreCreateAndUpdateDTO storeCreateAndUpdateDTO);
    void update(StoreCreateAndUpdateDTO storeCreateAndUpdateDTO, int id);
}

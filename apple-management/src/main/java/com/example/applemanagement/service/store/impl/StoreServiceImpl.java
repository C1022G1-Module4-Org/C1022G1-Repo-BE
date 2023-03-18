package com.example.applemanagement.service.store.impl;

import com.example.applemanagement.dto.storeDTO.StoreDTO;
import com.example.applemanagement.dto.storeDTO.StoreTypeDTO;
import com.example.applemanagement.model.store.Store;
import com.example.applemanagement.repository.store.IStoreRepository;
import com.example.applemanagement.service.store.IStoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements IStoreService {
    @Autowired
    private IStoreRepository iStoreRepository;

    @Override
    public Page<StoreDTO> listAll(Pageable pageable, String name) {
        Page<Store> storePage = iStoreRepository.findByNameAndIsDelete(pageable, name);
        List<StoreDTO> storeDTOList = new ArrayList<>();
        StoreDTO storeDTO;
        for (Store stores : storePage){
            storeDTO = new StoreDTO();
            storeDTO.setStoreTypeDTO(new StoreTypeDTO());
            BeanUtils.copyProperties(stores.getStoreType(), storeDTO.getStoreTypeDTO());
            BeanUtils.copyProperties(stores, storeDTO);
            storeDTOList.add(storeDTO);
        }
        return new PageImpl<>(storeDTOList, pageable, storePage.getTotalElements());
    }

    @Override
    public Store findById(int id) {
        return iStoreRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        Store store = findById(id);
        store.setDelete(true);
        iStoreRepository.save(store);
    }
}

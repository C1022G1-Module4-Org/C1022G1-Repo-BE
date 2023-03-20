package com.example.applemanagement.service.store.impl;

import com.example.applemanagement.dto.storeDTO.StoreCreateAndUpdateDTO;
import com.example.applemanagement.dto.storeDTO.StoreDTO;
import com.example.applemanagement.dto.storeDTO.StoreTypeDTO;
import com.example.applemanagement.model.store.Store;
import com.example.applemanagement.model.store.StoreType;
import com.example.applemanagement.repository.store.IStoreTypeRepository;
import com.example.applemanagement.service.store.IStoreTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class StoreTypeService implements IStoreTypeService {
    @Autowired
    private IStoreTypeRepository iStoreTypeRepository;

    public void setValueOfStoreDTO(StoreType storeType, StoreTypeDTO storeTypeDTO){
        Set<Store> storeSet = storeType.getStoreSet();
        Set<StoreCreateAndUpdateDTO> storeCreateAndUpdateDTOSet = new LinkedHashSet<>();
        StoreCreateAndUpdateDTO storeCreateAndUpdateDTO;
        for (Store store : storeSet){
            storeCreateAndUpdateDTO = new StoreCreateAndUpdateDTO();
            BeanUtils.copyProperties(store, storeCreateAndUpdateDTO);
            storeCreateAndUpdateDTOSet.add(storeCreateAndUpdateDTO);
        }
        BeanUtils.copyProperties(storeType, storeTypeDTO);
        storeTypeDTO.setStoreCreateAndUpdateDTOSet(storeCreateAndUpdateDTOSet);
    }

    @Override
    public StoreType findById(int id) {
        return iStoreTypeRepository.findById(id);
    }

    @Override
    public List<StoreTypeDTO> listAll() {
        List<StoreType> storeTypeList = iStoreTypeRepository.findAll();
        List<StoreTypeDTO> storeTypeDTOList = new ArrayList<>();
        StoreTypeDTO storeTypeDTO;
        for (StoreType storeType : storeTypeList){
            storeTypeDTO = new StoreTypeDTO();
            setValueOfStoreDTO(storeType, storeTypeDTO);
            BeanUtils.copyProperties(storeType, storeTypeDTO);
            storeTypeDTOList.add(storeTypeDTO);
        }
        return storeTypeDTOList;
    }
}

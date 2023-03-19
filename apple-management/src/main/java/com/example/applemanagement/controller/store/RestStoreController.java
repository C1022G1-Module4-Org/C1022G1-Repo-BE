package com.example.applemanagement.controller.store;

import com.example.applemanagement.dto.storeDTO.StoreCreateAndUpdateDTO;
import com.example.applemanagement.dto.storeDTO.StoreDTO;
import com.example.applemanagement.dto.storeDTO.StoreTypeDTO;
import com.example.applemanagement.model.store.Store;
import com.example.applemanagement.service.store.IStoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/store")
@CrossOrigin("*")
public class RestStoreController {
    @Autowired
    private IStoreService iStoreService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<StoreDTO> storeDTOPage(
            @Valid
            @PageableDefault(size = 3)Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String name){
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return iStoreService.listAll(pageable1,name);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteStore(@PathVariable int id){
        iStoreService.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createStore(@RequestBody StoreCreateAndUpdateDTO storeCreateAndUpdateDTO){
        iStoreService.create(storeCreateAndUpdateDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    public void updateStore(@RequestBody StoreCreateAndUpdateDTO storeCreateAndUpdateDTO, @PathVariable int id){
        iStoreService.update(storeCreateAndUpdateDTO, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{id}")
    public StoreCreateAndUpdateDTO detailStore(@PathVariable int id){
        Store store = iStoreService.findById(id);
        StoreCreateAndUpdateDTO storeCreateAndUpdateDTO = new StoreCreateAndUpdateDTO();
        storeCreateAndUpdateDTO.setStoreTypeDTO(new StoreTypeDTO());
        BeanUtils.copyProperties(store.getStoreType(), storeCreateAndUpdateDTO.getStoreTypeDTO());
        BeanUtils.copyProperties(store, storeCreateAndUpdateDTO);
        return storeCreateAndUpdateDTO;
    }

}

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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            @PageableDefault(size = 7)Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String name){
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return iStoreService.listAll(pageable1,name);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteStore(@PathVariable int id){
        iStoreService.delete(id);
    }

    @PostMapping("")
    public ResponseEntity<?> createStore(@Validated @RequestBody StoreCreateAndUpdateDTO storeCreateAndUpdateDTO, BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            iStoreService.create(storeCreateAndUpdateDTO);
        }else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError errors : errorList){
                if (!map.containsKey(errors.getField())){
                    map.put(errors.getField(), errors.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new  ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStore(@Validated @RequestBody StoreCreateAndUpdateDTO storeCreateAndUpdateDTO, BindingResult bindingResult , @PathVariable int id) {
        if (!bindingResult.hasErrors()) {
            iStoreService.update(storeCreateAndUpdateDTO, id);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError errors : errorList) {
                if (!map.containsKey(errors.getField())) {
                    map.put(errors.getField(), errors.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
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
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/details/{id}")
    public StoreCreateAndUpdateDTO detailsStore(@PathVariable int id){
        Store store = iStoreService.findById(id);
        StoreCreateAndUpdateDTO storeCreateAndUpdateDTO = new StoreCreateAndUpdateDTO();
        storeCreateAndUpdateDTO.setStoreTypeDTO(new StoreTypeDTO());
        BeanUtils.copyProperties(store.getStoreType(), storeCreateAndUpdateDTO.getStoreTypeDTO());
        BeanUtils.copyProperties(store, storeCreateAndUpdateDTO);
        return storeCreateAndUpdateDTO;
    }
}

package com.example.applemanagement.controller.store;

import com.example.applemanagement.dto.storeDTO.StoreDTO;
import com.example.applemanagement.service.store.IStoreService;
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

}

package com.example.applemanagement.controller.store;

import com.example.applemanagement.dto.storeDTO.StoreTypeDTO;
import com.example.applemanagement.service.store.IStoreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin("*")
public class RestStoreTypeController {
    @Autowired
    private IStoreTypeService iStoreTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<StoreTypeDTO> listAllType(){
        return iStoreTypeService.listAll();
    }
}

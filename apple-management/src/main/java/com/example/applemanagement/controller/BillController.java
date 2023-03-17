package com.example.applemanagement.controller;

import com.example.applemanagement.dto.billDTO.BillDTO;
import com.example.applemanagement.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bill")
@CrossOrigin("*")
public class BillController {
    @Autowired
    private IBillService iBillService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BillDTO> billDTOPage(@Valid
                                     @PageableDefault(size = 3) Pageable pageable,
                                     @RequestParam(required = false, defaultValue = "") String code) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return iBillService.listAll(pageable1, code);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteBill(@PathVariable int id){
        iBillService.delete(id);
    }

}

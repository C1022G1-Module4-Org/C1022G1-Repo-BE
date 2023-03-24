package com.example.applemanagement.service.bill.impl;

import com.example.applemanagement.dto.billDetailDTO.BillDetailDTO;
import com.example.applemanagement.service.bill.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailService implements IBillDetailService {
    @Autowired
    IBillDetailService iBillDetailService;
    @Override
    public void createBill(BillDetailDTO billDetailDTO) {
        this.iBillDetailService.createBill(billDetailDTO);
    }

    @Override
    public void findAll() {

    }
}

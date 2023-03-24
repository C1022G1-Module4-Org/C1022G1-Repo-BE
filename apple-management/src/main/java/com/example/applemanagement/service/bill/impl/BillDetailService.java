package com.example.applemanagement.service.bill.impl;

import com.example.applemanagement.dto.billDetailDTO.BillDetailDTO;
import com.example.applemanagement.repository.bill.IBillRepository;
import com.example.applemanagement.service.bill.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailService implements IBillDetailService {

    @Autowired
    private IBillRepository iBillRepository;
    @Override
    public void createBill(BillDetailDTO billDetailDTO) {

    }

    @Override
    public void findAll() {
    this.iBillRepository.findAll();
    }
}

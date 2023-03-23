package com.example.applemanagement.service.bill.impl;

import com.example.applemanagement.model.billDetail.Bill;
import com.example.applemanagement.repository.bill.IBillRepository;
import com.example.applemanagement.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;
    @Override
    public List<Bill> showList() {
        return billRepository.findAll();
    }
}

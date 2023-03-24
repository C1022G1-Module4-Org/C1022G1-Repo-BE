package com.example.applemanagement.service.bill;

import com.example.applemanagement.dto.billDetailDTO.BillDetailDTO;
import org.springframework.stereotype.Service;

public interface IBillDetailService {
    void createBill(BillDetailDTO billDetailDTO);
    void findAll();
}

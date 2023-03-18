package com.example.applemanagement.service;

import com.example.applemanagement.dto.billDTO.BillDTO;
import com.example.applemanagement.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBillService {
    Page<BillDTO> listAll(Pageable pageable, String code);
    Bill findById(int id);
    void delete (int id);
}

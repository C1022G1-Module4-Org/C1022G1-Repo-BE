package com.example.applemanagement.service.impl;

import com.example.applemanagement.dto.billDTO.BillDTO;
import com.example.applemanagement.dto.billDTO.BillTypeDTO;
import com.example.applemanagement.model.bill.Bill;
import com.example.applemanagement.repository.IBillRepository;
import com.example.applemanagement.service.IBillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    private IBillRepository iBillRepository;

    @Override
    public Page<BillDTO> listAll(Pageable pageable, String code) {
        Page<Bill> billPage = iBillRepository.findByCodeAnd(pageable,code);
        List<BillDTO> billDTOList = new ArrayList<>();
        BillDTO billDTO;
        for (Bill bills : billPage){
            billDTO = new BillDTO();
            billDTO.setBillTypeDTO(new BillTypeDTO());
            BeanUtils.copyProperties(bills.getBillType(), billDTO.getBillTypeDTO());
            BeanUtils.copyProperties(bills, billDTO);
            billDTOList.add(billDTO);
        }
        return new PageImpl<>(billDTOList, pageable, billPage.getTotalElements());
    }

    @Override
    public Bill findById(int id) {
        return iBillRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        Bill bill =  findById(id);
        bill.setDelete(true);
        iBillRepository.save(bill);
    }
}

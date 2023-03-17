package com.example.applemanagement.dto.billDTO;

import com.example.applemanagement.model.bill.BillType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BillDTO {
    private Integer id;
    private String code;
    private String name;
    private String date;
    private BillTypeDTO billTypeDTO;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BillDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BillTypeDTO getBillTypeDTO() {
        return billTypeDTO;
    }

    public void setBillTypeDTO(BillTypeDTO billTypeDTO) {
        this.billTypeDTO = billTypeDTO;
    }
}

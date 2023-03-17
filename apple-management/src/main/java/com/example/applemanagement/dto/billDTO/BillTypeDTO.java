package com.example.applemanagement.dto.billDTO;

import com.example.applemanagement.model.bill.Bill;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

public class BillTypeDTO {
    private Integer idType;
    private String type;
    private Set<BillDTO> billDTOSet;

    public BillTypeDTO() {
    }

    public BillTypeDTO(Integer idType, String type) {
        this.idType = idType;
        this.type = type;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<BillDTO> getBillDTOSet() {
        return billDTOSet;
    }

    public void setBillDTOSet(Set<BillDTO> billDTOSet) {
        this.billDTOSet = billDTOSet;
    }
}

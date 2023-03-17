package com.example.applemanagement.model.bill;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bill_type")
public class BillType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType;
    private String type;
    @OneToMany(mappedBy = "billType", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Bill> billSet;

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }

    public BillType() {
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
}

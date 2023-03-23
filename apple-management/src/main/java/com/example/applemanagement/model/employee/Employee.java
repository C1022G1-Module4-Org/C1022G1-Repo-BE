package com.example.applemanagement.model.employee;

import com.example.applemanagement.model.billDetail.Bill;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)")
    private String name;
    private String dateOfBirth;
    @Size(max = 15)
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String idCard;
    @Size(max = 15)
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String phoneNumber;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @Size(max = 250)
    @Column(columnDefinition = "varchar(250)")
    private String imgUrl;
    @OneToMany(mappedBy = "employeeId" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Bill> billSet;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;

    public Employee(Long id, String name, String dateOfBirth, String idCard, String phoneNumber, String address, String imgUrl, Set<Bill> billSet, Position position) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.imgUrl = imgUrl;
        this.billSet = billSet;
        this.position = position;
    }



    public Employee() {
    }

    public Employee(Long id, String name, String dateOfBirth, String idCard, String phoneNumber, String address, String imgUrl, Position position) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.imgUrl = imgUrl;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Position getPosition() {
        return position;
    }

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

package com.example.applemanagement.dto.billDetailDTO;

import com.example.applemanagement.dto.customerDTO.CustomerDTO;
import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.dto.productDTO.ProductDTO;
import com.example.applemanagement.dto.storeDTO.StoreDTO;

public class BillDetailDTO {
    private Integer id;
    private String date_time;
    private String description;
    private String name;
    private CustomerDTO customerDTO;
    private EmployeeDTO employeeDTO;
    private StoreDTO storeDTO;
    private ProductDTO productDTO;
    private BillDetailDTO billDetailDTO;
    public BillDetailDTO() {
    }

    public BillDetailDTO getBillDetailDTO() {
        return billDetailDTO;
    }

    public void setBillDetailDTO(BillDetailDTO billDetailDTO) {
        this.billDetailDTO = billDetailDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

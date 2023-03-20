package com.example.applemanagement.dto.productDTO;

import com.example.applemanagement.model.product.MadeIn;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductDTO {

    private Integer id;

    private String name;

    private String dateSize;
    private String img;
    private String price;
    private String quantity;
    private String describeProduct;

    private MadeIn madeIn;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, String dateSize, String img, String price, String quantity, String describeProduct, MadeIn madeIn) {
        this.id = id;
        this.name = name;
        this.dateSize = dateSize;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.describeProduct = describeProduct;
        this.madeIn = madeIn;
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

    public String getDateSize() {
        return dateSize;
    }

    public void setDateSize(String dateSize) {
        this.dateSize = dateSize;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public MadeIn getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(MadeIn madeIn) {
        this.madeIn = madeIn;
    }
}

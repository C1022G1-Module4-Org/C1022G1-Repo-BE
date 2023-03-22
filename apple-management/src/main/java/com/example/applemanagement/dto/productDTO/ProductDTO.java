package com.example.applemanagement.dto.productDTO;

import com.example.applemanagement.model.product.MadeIn;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class ProductDTO {

    private Integer id;
    @NotBlank(message = "Product name is required.")
    @Size(max = 100, message = "Product name cannot be longer than 100 characters.")
    private String name;

    private String dateSize;
    @NotBlank(message = "Product image URL is required.")
    @URL(message = "Product image URL must be a valid URL.")
    private String img;
    @NotBlank(message = "Product price is required.")
//    @Pattern(regexp = "^\\d{1,6}(\\.\\d{1,2})?$", message = "Product price must be a valid decimal, with up to 2 decimal places.")
    private String price;
    @NotBlank(message = "Product quantity is required.")
    @Positive(message = "Product quantity must be a positive integer.")
    private String quantity;
    @NotBlank(message = "Product description is required.")
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

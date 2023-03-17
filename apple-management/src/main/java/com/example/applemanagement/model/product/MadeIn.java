package com.example.applemanagement.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MadeIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String placeMadeIn;

    @OneToMany(mappedBy = "madeIn", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> productSet;

    public MadeIn() {
    }

    public MadeIn(Integer id, String placeMadeIn, Set<Product> productSet) {
        this.id = id;
        this.placeMadeIn = placeMadeIn;
        this.productSet = productSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceMadeIn() {
        return placeMadeIn;
    }

    public void setPlaceMadeIn(String placeMadeIn) {
        this.placeMadeIn = placeMadeIn;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}

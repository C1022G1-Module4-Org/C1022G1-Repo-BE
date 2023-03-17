package com.example.applemanagement.service.product;

import com.example.applemanagement.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> listAllProduct(String search, Pageable pageable);
}

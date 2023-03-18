package com.example.applemanagement.service.product.impl;

import com.example.applemanagement.model.product.Product;
import com.example.applemanagement.repository.product.IProductRepository;
import com.example.applemanagement.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Page<Product> listAllProduct(String search, Pageable pageable) {
        return productRepository.findProductByNameContaining(search, pageable);
    }
}

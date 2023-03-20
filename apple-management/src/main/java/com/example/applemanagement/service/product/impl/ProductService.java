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

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product product1 = findProductById(id);
        product1.setName(product.getName());
        product1.setDescribeProduct(product.getDescribeProduct());
        product1.setImg(product.getImg());
        product1.setPrice(product.getPrice());
        product1.setDateSize((product.getDateSize()));
        product1.setQuantity(product.getQuantity());
        product1.setMadeIn(product.getMadeIn());
        return productRepository.save(product1);
    }
}

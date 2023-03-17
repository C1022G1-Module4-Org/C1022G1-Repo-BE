package com.example.applemanagement.repository.product;

import com.example.applemanagement.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findProductByNameContaining(String search, Pageable pageable);
}

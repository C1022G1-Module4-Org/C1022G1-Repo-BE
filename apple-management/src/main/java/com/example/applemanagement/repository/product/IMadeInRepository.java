package com.example.applemanagement.repository.product;

import com.example.applemanagement.model.product.MadeIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMadeInRepository extends JpaRepository<MadeIn,Integer> {
}

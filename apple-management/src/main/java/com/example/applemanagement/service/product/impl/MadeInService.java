package com.example.applemanagement.service.product.impl;

import com.example.applemanagement.model.product.MadeIn;
import com.example.applemanagement.repository.product.IMadeInRepository;
import com.example.applemanagement.service.product.IMadeInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MadeInService implements IMadeInService {
    @Autowired
    private IMadeInRepository madeInRepository;

    @Override
    public List<MadeIn> findAllMadeIn() {
        return madeInRepository.findAll();
    }
}

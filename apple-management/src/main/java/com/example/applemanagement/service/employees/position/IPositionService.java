package com.example.applemanagement.service.employees.position;

import com.example.applemanagement.model.employee.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPositionService{
    List<Position> findAll();
}

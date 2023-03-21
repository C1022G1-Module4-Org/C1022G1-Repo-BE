package com.example.applemanagement.repository.employee;

import com.example.applemanagement.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Long> {
}

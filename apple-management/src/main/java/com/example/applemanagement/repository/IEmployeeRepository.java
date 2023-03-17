package com.example.applemanagement.repository;

import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<EmployeeDTO> findAllByNameContaining(
            @Param("nameSearch") String nameSearch,Pageable pageable);
}

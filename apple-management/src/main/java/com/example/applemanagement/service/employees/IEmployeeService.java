package com.example.applemanagement.service.employees;

import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IEmployeeService {
    Page<EmployeeDTO> findAllByName(String nameSearch, Pageable pageable);

    Page<Employee> findAll(Pageable pageable);

    void createEmployee(Employee employee);

    void deleteEmployee(Integer id);

    void editEmployee(Employee employee);
}

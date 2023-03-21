package com.example.applemanagement.service.employees;

import com.example.applemanagement.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IEmployeeService {
    Page<Employee> findAllEmployee(String search, Pageable pageable);

    void deleteEmployee(Employee employee);

    Employee findEmployeeById(long id);

    Employee createNewEmployee(Employee employee);

    Employee updateEmployee(long id, Employee employee);
}

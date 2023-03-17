package com.example.applemanagement.service.employees;

import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.model.employee.Employee;
import com.example.applemanagement.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<EmployeeDTO> findAllByName(String nameSearch, Pageable pageable) {
        return employeeRepository.findAllByNameContaining(nameSearch, pageable);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.save(employee);

    }
}

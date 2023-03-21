package com.example.applemanagement.service.employees;
import com.example.applemanagement.model.employee.Employee;
import com.example.applemanagement.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAllEmployee(String search, Pageable pageable) {
        return this.employeeRepository.findAllByNameContaining(search, pageable);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        this.employeeRepository.delete(employee);
    }

    @Override
    public Employee findEmployeeById(long id) {
        return this.employeeRepository.findById(id).get();
    }

    @Override
    public Employee createNewEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee employee1 = findEmployeeById(id);
        employee1.setName(employee.getName());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        employee1.setIdCard(employee.getIdCard());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setAddress(employee.getAddress());
        employee1.setImgUrl(employee.getImgUrl());
        employee1.setPosition(employee.getPosition());
        return employeeRepository.save(employee1);
    }
}

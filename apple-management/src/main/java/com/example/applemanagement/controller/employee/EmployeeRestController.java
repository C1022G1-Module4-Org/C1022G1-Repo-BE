package com.example.applemanagement.controller.employee;

import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.model.employee.Employee;
import com.example.applemanagement.service.employees.IEmployeeService;
import com.example.applemanagement.service.employees.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService positionService;

    @GetMapping("/list-employee")
    public ResponseEntity<Page<EmployeeDTO>> findAllEmployee(
            @RequestParam(required = false, defaultValue = "") String nameSearch,
            @RequestParam(required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<Employee> employees = employeeService.findAllByName(nameSearch, pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Page<EmployeeDTO> employeeDTOS = employees.map(EmployeeDTO::new);
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }
}


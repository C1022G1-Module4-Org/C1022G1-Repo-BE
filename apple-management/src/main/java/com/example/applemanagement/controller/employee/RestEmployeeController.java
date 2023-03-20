package com.example.applemanagement.controller.employee;

import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.dto.employeeDTO.PositionDTO;
import com.example.applemanagement.model.employee.Employee;
import com.example.applemanagement.service.employees.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
public class RestEmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/list-employee")
    public ResponseEntity<Page<EmployeeDTO>> findAllEmployee(
            @RequestParam(required = false, defaultValue = "") String nameSearch,
            @RequestParam(required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<EmployeeDTO> employeeDTOS = employeeService.findAllByName(nameSearch, pageable);
        if (employeeDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<EmployeeDTO> EmployeeDTOPage(
            @Valid
            @PageableDefault(size = 3) Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String name) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return employeeService.listAll(pageable1, name);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
    }
}




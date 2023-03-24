package com.example.applemanagement.controller.employee;

import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.model.employee.Employee;
import com.example.applemanagement.model.employee.Position;
import com.example.applemanagement.service.employees.IEmployeeService;
import com.example.applemanagement.service.employees.position.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apple/employee")
@CrossOrigin("*")
public class RestEmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService  positionService;

    @GetMapping("/list-employee")
    public Page<Employee> findAllEmployee(
            @PageableDefault(size = 2,sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String search) {
        Page<Employee> employee = employeeService.findAllEmployee(search, pageable);
        List<Employee> employees = employee.toList();
        return new PageImpl<>(employees, pageable,employee.getTotalElements());
    }

    @GetMapping("/position")
    public List<Position> findAllPosition(){
        return positionService.findAll();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewEmployeeTest(@Validated @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO,employee);
            return ResponseEntity.ok(employeeService.createNewEmployee(employee));
        } else {
            return getResponseEntity(bindingResult);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployee(@PathVariable long id) {
        Employee employee = this.employeeService.findEmployeeById(id);
        employeeService.deleteEmployee(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateEmployee( @PathVariable int id,@Validated @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO,employee);
            return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
        } else {
            return getResponseEntity(bindingResult);
        }
    }

    private ResponseEntity<?> getResponseEntity(BindingResult bindingResult) {
        Map<String, String> map = new LinkedHashMap<>();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            if (!map.containsKey(error.getField())) {
                map.put(error.getField(), error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/{id}")
//    public Employee updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDTO,employee);
//        return employeeService.updateEmployee(id,employee);
//    }
}




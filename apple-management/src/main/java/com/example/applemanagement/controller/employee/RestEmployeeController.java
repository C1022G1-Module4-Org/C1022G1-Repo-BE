package com.example.applemanagement.controller.employee;

import com.example.applemanagement.dto.employeeDTO.EmployeeDTO;
import com.example.applemanagement.model.employee.Employee;
import com.example.applemanagement.model.employee.Position;
import com.example.applemanagement.service.employees.IEmployeeService;
import com.example.applemanagement.service.employees.position.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Employee createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDTO,employee);
//        return employeeService.createNewEmployee(employee);
//    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewEmployeeTest(@Validated @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        return ResponseEntity.ok(employeeService.createNewEmployee(employee));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        Employee employee = this.employeeService.findEmployeeById(id);
        employeeService.deleteEmployee(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        return employeeService.updateEmployee(id,employee);
    }
}




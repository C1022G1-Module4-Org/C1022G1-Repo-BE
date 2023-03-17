package com.example.applemanagement.dto.employeeDTO;

import com.example.applemanagement.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

public class PositionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private Set<Employee> employeeList;

    public PositionDTO() {
    }

    public PositionDTO(Integer id, String name, Set<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

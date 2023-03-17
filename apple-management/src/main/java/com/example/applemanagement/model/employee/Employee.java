package com.example.applemanagement.model.employee;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)")
    private String name;
    private String dateOfBirth;
    @Size(max = 15)
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String idCard;
    @Size(max = 15)
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String phoneNumber;
    @Size(max = 45)
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @Size(max = 250)
    @Column(columnDefinition = "varchar(250)")
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;
}

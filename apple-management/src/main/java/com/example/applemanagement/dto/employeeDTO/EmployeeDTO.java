package com.example.applemanagement.dto.employeeDTO;

import com.example.applemanagement.model.employee.Position;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 45)
    @NotBlank(message = "Please enter name!")
    @Column(columnDefinition = "varchar(45)")
    @Pattern(regexp = "^(?!.*\\d)[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$|^([\\p{Lu}][\\p{Ll}]*)$", message = "The name needs to match the format. Ex: Nguyen Van A, Nguyễn Văn A")
    private String name;
    @Size(max = 10)
    @NotBlank(message = "Please enter date of birth!")
    private String dateOfBirth;
    @Size(max = 15)
    @NotBlank(message = "Please enter ID-Card")
    @Pattern(regexp = "(\\d{9})|(\\d{12})", message = "The Id-Card needs to match the format, Ex:XXXXXXXXX hoặc XXXXXXXXXXXX (X is a number from 0-9, the length of ID card is 9 digits, and the length of CCID is 12 digits.")
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String idCard;
    @Size(max = 15)
    @NotBlank(message = "Please enter Phone Number")
    @Pattern(regexp = "^((\\+?84)|0)(9[012346789]\\d{7})$", message = "The Phone Number needs to match the format Ex: 09Xxxxxxxx or +849Xxxxxxxx {X = 0/1/2/3/4/6/7/8/9}.")
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String phoneNumber;
    @Size(max = 45)
    @NotBlank(message = "Please enter Address")
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @Size(max = 250)
    @NotBlank(message = "Please enter the path to your portrait photo taken within the last 3 months.")
    @Pattern(regexp = "^(https?:\\/\\/)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)\\/([\\w\\d-]+)\\.(jpg|png|webm)", message = "Only accept images in .PNG, .JPG, and .Webm formats.")
    @Column(columnDefinition = "varchar(250)")
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String dateOfBirth, String idCard, String phoneNumber, String address, String imgUrl, Position position) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.imgUrl = imgUrl;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

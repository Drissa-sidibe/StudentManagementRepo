package com.sali.Studentmanagement.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {
    @Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long studentId;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    private Long departmentId;

    public Student() {
    }


    public Student(Long studentId, String firstName, String lastName, String phoneNumber, String email, LocalDate dob, Long departmentId) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.departmentId = departmentId;
    }

    public Student(Long id, Long studentId, String firstName, String lastName, String phoneNumber, String email, LocalDate dob, Long departmentId) {

        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.departmentId = departmentId;
        }
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return this.dob;
    }
    public void setAge(Integer age){
        this.age=age;
    }
    public Integer getAge() {//Period.between(this.dob, LocalDate.now()).getYears();
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Student{" +

                ", studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", departmentId=" + departmentId +
                '}';
    }


}

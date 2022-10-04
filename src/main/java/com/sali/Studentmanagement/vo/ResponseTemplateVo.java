package com.sali.Studentmanagement.vo;

import com.sali.Studentmanagement.entity.Student;

public class ResponseTemplateVo {
    private Student student;
    private Department department;

    public ResponseTemplateVo() {
    }

    public ResponseTemplateVo(Student student, Department department) {
        this.student = student;
        this.department = department;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

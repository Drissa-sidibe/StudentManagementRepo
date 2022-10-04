package com.sali.Studentmanagement.service;

import com.sali.Studentmanagement.entity.Student;
import com.sali.Studentmanagement.error.StudentNotFoundException;
import com.sali.Studentmanagement.vo.ResponseTemplateVo;

import java.util.List;

public interface I_StudentService {
        List<Student> findStudents();
        Student findStudentById(Long studentId) throws StudentNotFoundException;
        Student getByStudentDepartment(Long departmentId);
        Student addStudent(Student student);
        Student updateStudent(Long studentId, Student student);
        void deleteStudentById(Student studentId);

        ResponseTemplateVo getStudentWithDepartment(Long studentId);

//        ResponseTemplateVo getStudentWithDepartment(Long studentId);
}
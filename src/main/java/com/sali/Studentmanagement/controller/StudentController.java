package com.sali.Studentmanagement.controller;

import com.sali.Studentmanagement.entity.Student;
import com.sali.Studentmanagement.error.StudentNotFoundException;
import com.sali.Studentmanagement.service.StudentServiceImpl;
import com.sali.Studentmanagement.vo.ResponseTemplateVo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

//CircuitBreaker Definition
    private RestTemplate restTemplate;
    private static final String Base_url = "http://DEPARTMENT-SERVICE/departments/";
    private static final String circuitbreaker ="Department-service";

    @GetMapping("/circuitbreaker")
    @CircuitBreaker(name ="Department-service", fallbackMethod = "Department-FallBack")
    public String circuitBreaker(){
        String url = Base_url + "b";
        return restTemplate.getForObject( "", String.class);
    }
 public String serviceFallback(Exception e){
        return "Fall back method";
 }

    @GetMapping
    public List<Student> findStudents(){
       return studentService.findStudents();
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/studentName/{studentId}")
    public Student findStudentById( @PathVariable("studentId") long studentId) throws StudentNotFoundException {
        return studentService.findStudentById(studentId);
    }

    @GetMapping("{studentId}")
    public ResponseTemplateVo getStudentWithDepartment(@PathVariable("studentId") Long studentId) {
        return studentService.getStudentWithDepartment(studentId);
    }

//    @GetMapping("/studentName/{departmentId}")
//    public Student getByStudentDepartment(@PathVariable("departmentIs") long departmentId){
//        return studentService.getByStudentDepartment(departmentId);
//    }

    @DeleteMapping("{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Student studentId){
        studentService.deleteStudentById(studentId);
    }
    @PutMapping("{studentId}")
    public Student updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId,student);
    }
}

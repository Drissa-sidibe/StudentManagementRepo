package com.sali.Studentmanagement.service;

import com.sali.Studentmanagement.entity.Student;
import com.sali.Studentmanagement.error.StudentNotFoundException;
import com.sali.Studentmanagement.vo.Department;
import com.sali.Studentmanagement.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements I_StudentService {

   @Autowired
   private StudentRepository repository;

   @Autowired
    private RestTemplate restTemplate;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findStudents() {
        return repository.findAll();
    }

    @Override
    public Student findStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> studentOptional= repository.findById(studentId);
        if(!studentOptional.isPresent()){
            throw new StudentNotFoundException("This student"  + studentId + "does not exist");
        }
        return studentOptional.get();
    }

    @Override
    public Student getByStudentDepartment(Long departmentId) {
        return repository.findByDepartmentId(departmentId);
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {

        Student student1 =repository.findById(studentId).get();
        if (Objects.nonNull(student.getFirstName()) &&
                !"".equalsIgnoreCase(student.getFirstName())) {
            student1.setFirstName(student.getFirstName());
        }
//        if (Objects.nonNull(student.getLastName()) &&
//                !"".equalsIgnoreCase(student.getLastName())) {
//            student1.setLastName(student.getLastName());
//        }
//        if (Objects.nonNull(student.getPhoneNumber()) &&
//                !"".equalsIgnoreCase(student.getPhoneNumber())) {
//            student1.setPhoneNumber(student.getPhoneNumber());
//        }
//        if (Objects.nonNull(student.getEmail()) &&
//                !"".equalsIgnoreCase(student.getEmail())) {
//            student1.setEmail(student.getEmail());
//        }
       return repository.save(student);
    }

    @Override
    public void deleteStudentById(Student studentId) {
        repository.delete(studentId);
    }

     @Override
    public ResponseTemplateVo getStudentWithDepartment(Long studentId) {
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Student students =repository.findByStudentId(studentId);

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/"+ students.getDepartmentId(), Department.class);

        vo.setStudent(students);
        vo.setDepartment(department);
        return vo;
    }
}

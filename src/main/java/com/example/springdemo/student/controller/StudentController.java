package com.example.springdemo.student.controller;

import com.example.springdemo.exception.BaseException;
import com.example.springdemo.student.business.*;
import com.example.springdemo.student.exception.StudentException;
import com.example.springdemo.student.json.*;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.payload.StudentPayload;
import com.example.springdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentBusiness studentBusiness;
    @Autowired
    StudentIDCardBusiness studentIDCardBusiness;
    @Autowired
    EnrollmentBusiness enrollmentBusiness;
    @Autowired
    BookBusiness bookBusiness;
    @Autowired
    CourseBusiness courseBusiness;

    @PostMapping(value = "/student/insert")
    public ResponseEntity<Void> saveStudent(@RequestBody StudentPayload payload){
        studentBusiness.saveStudent(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<StudentListJson> updateStudent(@PathVariable("id") long id, @RequestBody StudentPayload payload) {
        Optional<Student> student = studentService.findOptionalById(id);
        if (student.isPresent()) {
            studentBusiness.updateStudent(student.get().getId(), payload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public StudentController(StudentService studentservice) {
        this.studentService = studentservice;
    }
//    @PostMapping(value = "/student/update/{id}")
//    public ResponseEntity<Void> updateStudent(@PathVariable("id") long id, @RequestBody StudentPayload payload){
//        studentBusiness.updateStudent(id, payload);
//        return new ResponseEntity<>(HttpStatus.OK);

//    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<StudentListJson>> getAllStudents() throws BaseException{
        return ResponseEntity.ok(studentBusiness.getListStudent());
    }


    @GetMapping(value = "/students/{id}")
    public ResponseEntity<StudentListJson>
    getStudentById(@PathVariable("id") long id) throws BaseException{
        return ResponseEntity.ok(studentBusiness.getStudentId(id));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id){
        try {
            studentBusiness.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/students/{id}/card")
    public ResponseEntity<StudentIDCardListJson> getStudentIdCardByStudentId(@PathVariable("id")Student student) throws StudentException{
        return ResponseEntity.ok(studentIDCardBusiness.getStudentIdCardByStudentId(student));
    }

    @GetMapping(value = "/students/{id}/enrollment")
    public ResponseEntity<EnrollmentListJson> getEnrolmentByStudentId(@PathVariable("id") Student student) throws StudentException {
        return ResponseEntity.ok(enrollmentBusiness.getStudentIdCardByStudentId(student));
    }

    @GetMapping(value = "/students/{id}/book")
    public ResponseEntity<BookListJson> getBookByStudentId(@PathVariable("id") Student student) throws StudentException{
        return ResponseEntity.ok(bookBusiness.getBookByStudentId(student));
    }

    @GetMapping(value = "/course/{id}")
    public ResponseEntity<CourseListJson> getCourseById(@PathVariable("id") long id) throws StudentException{
        return ResponseEntity.ok(courseBusiness.getCourseId(id));
    }
}

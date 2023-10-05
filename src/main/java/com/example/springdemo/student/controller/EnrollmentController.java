package com.example.springdemo.student.controller;


import com.example.springdemo.student.business.EnrollmentBusiness;
import com.example.springdemo.student.json.EnrollmentListJson;
import com.example.springdemo.student.json.StudentListJson;
import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.model.Enrollment;
import com.example.springdemo.student.payload.CoursePayload;
import com.example.springdemo.student.payload.EnrollmentPayload;
import com.example.springdemo.student.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    @Autowired
    EnrollmentBusiness enrollmentBusiness;

    @Autowired
    EnrollService enrollService;

    @PostMapping(value = "/enroll/insert")
    public ResponseEntity<Void> saveBook(@RequestBody EnrollmentPayload payload){
        enrollmentBusiness.saveEnrollment(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/enroll/update/{id}")
    public ResponseEntity<EnrollmentListJson> updateStudent(@PathVariable("id") long id, @RequestBody EnrollmentPayload payload) {
        Optional<Enrollment> enrollment = enrollService.findOptionalById(id);
        if (enrollment.isPresent()) {
            enrollmentBusiness.updateEnrollment(enrollment.get().getId(), payload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

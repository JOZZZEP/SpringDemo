package com.example.springdemo.student.controller;

import com.example.springdemo.student.business.StudentIDCardBusiness;
import com.example.springdemo.student.json.StudentIDCardListJson;
import com.example.springdemo.student.json.StudentListJson;
import com.example.springdemo.student.model.StudentIdCard;
import com.example.springdemo.student.payload.StudentIDCardPayload;
import com.example.springdemo.student.service.StudentIDCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentIDCardController {

    @Autowired
    StudentIDCardBusiness studentIDCardBusiness;

    @Autowired
    StudentIDCardService studentIDCardService;

    @PostMapping(value = "/studentIDCard/insert")
    public ResponseEntity<Void> saveBook(@RequestBody StudentIDCardPayload payload){
        studentIDCardBusiness.saveStudentIDCard(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/studentIDCard/update/{id}")
    public ResponseEntity<StudentIDCardListJson> updateStudent(@PathVariable("id") long id, @RequestBody StudentIDCardPayload payload) {
        Optional<StudentIdCard> studentIdCard = studentIDCardService.findOptionalById(id);
        if (studentIdCard.isPresent()) {
            studentIDCardBusiness.updateStudentIDCard(studentIdCard.get().getId(), payload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.springdemo.student.service.impl;

import com.example.springdemo.student.model.Student;

import java.util.List;

public interface IStudent {
    List<Student> getAllStudents();
    Student findById(long id);
    Student findByEmail(String email);
    Student save(Student student);
    void deleteById(long id);
}

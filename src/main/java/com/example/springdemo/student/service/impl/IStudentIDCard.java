package com.example.springdemo.student.service.impl;

import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.model.StudentIdCard;

import java.util.List;

public interface IStudentIDCard {
    List<StudentIdCard> findAllStudentIdCard();
    StudentIdCard findById(long id);
    StudentIdCard findByCardNumberContaining(String name);
    StudentIdCard findByStudentId(Student studentId);
    StudentIdCard save(StudentIdCard studentIdCard);
    void deleteById(long id);
}

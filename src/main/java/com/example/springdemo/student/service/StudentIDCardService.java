package com.example.springdemo.student.service;

import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.model.StudentIdCard;
import com.example.springdemo.student.repository.StudentIDCardRepository;
import com.example.springdemo.student.service.impl.IStudentIDCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentIDCardService implements IStudentIDCard {

    @Autowired
    StudentIDCardRepository studentIDCardRepository;
    @Override
    public List<StudentIdCard> findAllStudentIdCard() {
        return studentIDCardRepository.findAll();
    }

    @Override
    public StudentIdCard findById(long id) {
        return studentIDCardRepository.findById(id);
    }

    @Override
    public StudentIdCard findByCardNumberContaining(String name) {
        return studentIDCardRepository.findByCardNumberContaining(name);
    }

    @Override
    public StudentIdCard findByStudentId(Student studentId) {
        return studentIDCardRepository.findByStudentId(studentId);
    }

    @Override
    public StudentIdCard save(StudentIdCard studentIdCard) {
        return studentIDCardRepository.save(studentIdCard);
    }

    @Override
    public void deleteById(long id) {
        studentIDCardRepository.deleteById(id);
    }

    public Optional<StudentIdCard> findOptionalById(long id) {
        return studentIDCardRepository.findOptionalById(id);
    }
}

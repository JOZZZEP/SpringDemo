package com.example.springdemo.student.repository;

import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.model.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentIDCardRepository extends JpaRepository<StudentIdCard, Long> {
    StudentIdCard findById(long id);
    Optional<StudentIdCard> findOptionalById(long id);
    StudentIdCard findByStudentId(Student studentId);
    StudentIdCard findByCardNumberContaining(String number);
}

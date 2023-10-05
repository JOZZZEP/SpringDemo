package com.example.springdemo.student.repository;

import com.example.springdemo.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findById(long id);
    Optional<Student> findOptionalById(long id);
    Student findByEmail(String email);
}

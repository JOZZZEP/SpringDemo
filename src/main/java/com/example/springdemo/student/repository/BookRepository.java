package com.example.springdemo.student.repository;

import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);
    Optional<Book> findOptionalById(long id);
    Book findByStudentId(Student student);
    Book findByBookNameContaining(String bookName);
}

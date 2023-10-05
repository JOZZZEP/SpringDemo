package com.example.springdemo.student.service.impl;

import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Student;

import java.util.List;

public interface IBook {
    List<Book> findAllBook();
    Book findById(long id);
    Book findByStudentId(Student studentId);
    Book findByBookNameContaining(String bookName);
    Book save(Book book);
    void deleteById(long id);
}

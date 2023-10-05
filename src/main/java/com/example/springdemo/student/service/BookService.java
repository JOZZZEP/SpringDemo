package com.example.springdemo.student.service;

import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.repository.BookRepository;
import com.example.springdemo.student.service.impl.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBook {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book findByStudentId(Student studentId) {
        return bookRepository.findByStudentId(studentId);
    }

    @Override
    public Book findByBookNameContaining(String bookName) {
        return bookRepository.findByBookNameContaining(bookName);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> findOptionalById(long id) {
        return bookRepository.findOptionalById(id);
    }
}

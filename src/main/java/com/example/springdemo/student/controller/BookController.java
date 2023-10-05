package com.example.springdemo.student.controller;

import com.example.springdemo.student.business.BookBusiness;
import com.example.springdemo.student.json.BookListJson;
import com.example.springdemo.student.json.StudentListJson;
import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.payload.BookPayload;
import com.example.springdemo.student.payload.StudentPayload;
import com.example.springdemo.student.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookBusiness bookBusiness;

    @Autowired
    BookService bookService;

    @PostMapping(value = "/book/insert")
    public ResponseEntity<Void> saveBook(@RequestBody BookPayload bookPayload){
        bookBusiness.saveBook(bookPayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/book/update/{id}")
    public ResponseEntity<BookListJson> updateStudent(@PathVariable("id") long id, @RequestBody BookPayload payload) {
        Optional<Book> book = bookService.findOptionalById(id);
        if (book.isPresent()) {
            bookBusiness.updateBook(book.get().getId(), payload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

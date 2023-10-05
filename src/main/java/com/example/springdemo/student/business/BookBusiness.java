package com.example.springdemo.student.business;

import com.example.springdemo.student.json.BookListJson;
import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.payload.BookPayload;
import com.example.springdemo.student.service.BookService;
import com.example.springdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBusiness {
	@Autowired
	BookService bookService;

	@Autowired
	StudentService studentService;

	public void saveBook(BookPayload bookPayload){
		Book book = new Book(
				studentService.findById(bookPayload.getStudentId()),
				bookPayload.getBookName()
				);
		bookService.save(book);
	}

	public void updateBook(long id, BookPayload bookPayload){
		Book book = bookService.findById(id);
		book.setStudentId(studentService.findById(bookPayload.getStudentId()));
		book.setBookName(bookPayload.getBookName());
		bookService.save(book);
	}

	public BookListJson getBookByStudentId(Student student) {
		return BookListJson.packJson(bookService.findByStudentId(student));
	}
}

package com.example.springdemo.student.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BookListJson {
	private long id;
	private Student student;
	private String bookName;
	private LocalDateTime createdAt;
	
	public static BookListJson packJson(Book book) {
		BookListJson bookListJson = new BookListJson();
		bookListJson.setId(book.getId());
		bookListJson.setStudent(book.getStudentId());
		bookListJson.setBookName(book.getBookName());
		bookListJson.setCreatedAt(book.getCreateAt());
		
		return bookListJson;
	}
	
	public static List<BookListJson> packJsons(List<Book> books){
		List<BookListJson> bookListJsons = new ArrayList<>();
		for (Book book : books) {
			bookListJsons.add(packJson(book));
		}
		return bookListJsons;
	}
}

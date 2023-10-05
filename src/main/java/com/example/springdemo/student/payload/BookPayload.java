package com.example.springdemo.student.payload;

import com.example.springdemo.student.model.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPayload {
    private long studentId;
    private String bookName;
}

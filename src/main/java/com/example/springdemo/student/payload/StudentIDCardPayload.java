package com.example.springdemo.student.payload;

import com.example.springdemo.student.model.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class StudentIDCardPayload {
    private long studentId;
    private String cardNumber;
}

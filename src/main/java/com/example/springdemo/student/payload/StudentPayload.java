package com.example.springdemo.student.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentPayload {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}

package com.example.springdemo.student.payload;

import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.model.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentPayload {
    private long studentId;
    private long courseId;
}

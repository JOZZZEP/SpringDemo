package com.example.springdemo.student.service.impl;

import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.model.Enrollment;
import com.example.springdemo.student.model.Student;

import java.util.List;

public interface IEnrollment {
    List<Enrollment> findAllEnrollment();
    Enrollment findById(long id);
    Enrollment findByStudentId(Student studentId);
    Enrollment findByCourseId(Course courseId);
    Enrollment save(Enrollment enrollment);
    void deleteById(long id);
}

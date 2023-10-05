package com.example.springdemo.student.service.impl;

import com.example.springdemo.student.model.Course;

import java.util.List;

public interface ICourse {
    List<Course> findAllCourses();
    Course findById(long id);
    Course findByNameContaining(String name);
    Course findByDepartmentContaining(String departmentName);
    Course save(Course course);
    void deleteById(long id);
}

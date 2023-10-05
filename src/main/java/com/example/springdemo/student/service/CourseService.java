package com.example.springdemo.student.service;

import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.repository.CourseRepository;
import com.example.springdemo.student.service.impl.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourse {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course findByNameContaining(String name) {
        return courseRepository.findByNameContaining(name);
    }

    @Override
    public Course findByDepartmentContaining(String departmentName) {
        return courseRepository.findByDepartmentContaining(departmentName);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }

    public Optional<Course> findOptionalById(long id) {
        return courseRepository.findOptionalById(id);
    }
}

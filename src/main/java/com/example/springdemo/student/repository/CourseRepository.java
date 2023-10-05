package com.example.springdemo.student.repository;

import com.example.springdemo.student.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findById(long id);
    Optional<Course> findOptionalById(long id);
    Course findByNameContaining(String name);
    Course findByDepartmentContaining(String name);
}

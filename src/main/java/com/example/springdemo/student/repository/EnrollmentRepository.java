package com.example.springdemo.student.repository;

import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.model.Enrollment;
import com.example.springdemo.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Enrollment findById(long id);
    Optional<Enrollment> findOptionalById(long id);
    Enrollment findByStudentId(Student studentId);
    Enrollment findByCourseId(Course courseId);
}

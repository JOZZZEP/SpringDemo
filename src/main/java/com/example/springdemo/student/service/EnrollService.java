package com.example.springdemo.student.service;

import com.example.springdemo.student.model.Book;
import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.model.Enrollment;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.repository.EnrollmentRepository;
import com.example.springdemo.student.service.impl.IEnrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollService implements IEnrollment {
    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Override
    public List<Enrollment> findAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment findById(long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Enrollment findByStudentId(Student studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public Enrollment findByCourseId(Course courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteById(long id) {
        enrollmentRepository.deleteById(id);
    }

    public Optional<Enrollment> findOptionalById(long id) {
        return enrollmentRepository.findOptionalById(id);
    }
}

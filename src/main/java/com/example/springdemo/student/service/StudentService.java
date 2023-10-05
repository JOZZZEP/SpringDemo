package com.example.springdemo.student.service;

import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.repository.StudentRepository;
import com.example.springdemo.student.service.impl.IStudent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudent {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> findOptionalById(long id) {
        return studentRepository.findOptionalById(id);
    }
}

package com.example.springdemo.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "department",nullable = false)
    private String department;

    public Course() {

    }

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }

}

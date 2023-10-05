package com.example.springdemo.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Student studentId;

    @Column(name = "book_name",nullable = false)
    private String bookName;

    @CreationTimestamp
    @Column(name = "create_at",nullable = false,
    updatable = false, insertable = false,
    columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    public Book() {

    }

    public Book(Student studentId, String bookName) {
        this.studentId = studentId;
        this.bookName = bookName;
    }
}

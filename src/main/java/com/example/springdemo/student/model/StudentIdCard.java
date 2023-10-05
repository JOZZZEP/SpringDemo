package com.example.springdemo.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
            @UniqueConstraint(name = "student_card_number_uk",columnNames = "card_number")
        }
    )

public class StudentIdCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student studentId;

    @Column(name = "card_number", unique = true, nullable = false)
    private String cardNumber;

    public StudentIdCard() {

    }

    public StudentIdCard(Student studentId, String cardNumber) {
        this.studentId = studentId;
        this.cardNumber = cardNumber;
    }
}

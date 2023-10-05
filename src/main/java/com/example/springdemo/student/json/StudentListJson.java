package com.example.springdemo.student.json;

import com.example.springdemo.student.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentListJson {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public static StudentListJson packJson(Student student){
        StudentListJson studentListJson = new StudentListJson();
        studentListJson.setId(student.getId());
        studentListJson.setFirstName(student.getFirstName());
        studentListJson.setLastName(student.getLastName());
        studentListJson.setEmail(student.getEmail());
        studentListJson.setAge(student.getAge());
        return studentListJson;
    }

    public  static List<StudentListJson> packJsons(List<Student> students){
        List<StudentListJson> studentListJsons = new ArrayList<>();
        for (Student student : students){
            studentListJsons.add(packJson(student));
        }
        return studentListJsons;
    }
}

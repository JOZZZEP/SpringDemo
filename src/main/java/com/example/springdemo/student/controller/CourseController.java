package com.example.springdemo.student.controller;

import com.example.springdemo.student.business.CourseBusiness;
import com.example.springdemo.student.json.CourseListJson;
import com.example.springdemo.student.json.StudentListJson;
import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.payload.CoursePayload;
import com.example.springdemo.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseBusiness courseBusiness;

    @Autowired
    CourseService courseService;

    @PostMapping(value = "/course/insert")
    public ResponseEntity<Void> saveBook(@RequestBody CoursePayload payload){
        courseBusiness.saveCourse(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/course/update/{id}")
    public ResponseEntity<CourseListJson> updateStudent(@PathVariable("id") long id, @RequestBody CoursePayload payload) {
        Optional<Course> course = courseService.findOptionalById(id);
        if (course.isPresent()) {
            courseBusiness.updateCourse(course.get().getId(), payload);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

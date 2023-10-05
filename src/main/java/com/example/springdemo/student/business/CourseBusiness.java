package com.example.springdemo.student.business;

import com.example.springdemo.student.json.CourseListJson;
import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.payload.CoursePayload;
import com.example.springdemo.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseBusiness {
	@Autowired
	CourseService courseService;

	public void saveCourse(CoursePayload coursePayload){
		Course course = new Course(
				coursePayload.getName(),
				coursePayload.getDepartment()
		);
		courseService.save(course);
	}

	public void updateCourse(long id, CoursePayload coursePayload){
		Course course = courseService.findById(id);
		course.setName(coursePayload.getName());
		course.setDepartment(coursePayload.getDepartment());
		courseService.save(course);
	}

	public CourseListJson getCourseId(long id) {
		return CourseListJson.packJson(courseService.findById(id));
	}
}

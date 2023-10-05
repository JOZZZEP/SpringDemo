package com.example.springdemo.student.json;

import com.example.springdemo.student.model.Course;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class CourseListJson {
	private long id;
	private String name;
	private String department;
	
	public static CourseListJson packJson(Course course) {
		CourseListJson courseListJson = new CourseListJson();
		courseListJson.setId(course.getId());
		courseListJson.setName(course.getName());
		courseListJson.setDepartment(course.getDepartment());
		
		return courseListJson;
	}
	
	public static List<CourseListJson> packJsons(List<Course> courses){
		List<CourseListJson> courseListJsons = new ArrayList<>();
		for(Course course : courses) {
			courseListJsons.add(packJson(course));
		}
		
		return courseListJsons;
	}
}

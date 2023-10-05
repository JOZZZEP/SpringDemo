package com.example.springdemo.student.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.springdemo.student.model.Course;
import com.example.springdemo.student.model.Enrollment;
import com.example.springdemo.student.model.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EnrollmentListJson {
	private long id;
	private Student student;
	private Course course;
	private LocalDateTime createdAt;
	
	public static EnrollmentListJson packJson(Enrollment enrolment) {
		EnrollmentListJson enrollmentListJson = new EnrollmentListJson();
		enrollmentListJson.setId(enrolment.getId());
		enrollmentListJson.setStudent(enrolment.getStudentId());
		enrollmentListJson.setCourse(enrolment.getCourseId());
		enrollmentListJson.setCreatedAt(enrolment.getCreateAt());
		return enrollmentListJson;
	}

	public static List<EnrollmentListJson> packJsons(List<Enrollment> enrollments){
		List<EnrollmentListJson> enrollmentListJsons = new ArrayList<>();
		for(Enrollment enrollment : enrollments) {
			enrollmentListJsons.add(packJson(enrollment));
		}
		return enrollmentListJsons;
	}
}

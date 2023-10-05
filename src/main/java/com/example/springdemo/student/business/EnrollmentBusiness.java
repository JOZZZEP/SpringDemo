package com.example.springdemo.student.business;

import com.example.springdemo.student.json.EnrollmentListJson;
import com.example.springdemo.student.model.Enrollment;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.payload.EnrollmentPayload;
import com.example.springdemo.student.service.CourseService;
import com.example.springdemo.student.service.EnrollService;
import com.example.springdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnrollmentBusiness {
	
	@Autowired
	EnrollService enrollmentService;

	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;

	public void saveEnrollment(EnrollmentPayload enrollmentPayload){
		Enrollment enrollment = new Enrollment(
				studentService.findById(enrollmentPayload.getStudentId()),
				courseService.findById(enrollmentPayload.getCourseId())
		);
		enrollmentService.save(enrollment);
	}

	public void updateEnrollment(long id, EnrollmentPayload enrollmentPayload){
		Enrollment enrollment = enrollmentService.findById(id);
		enrollment.setStudentId(studentService.findById(enrollmentPayload.getStudentId()));
		enrollment.setCourseId(courseService.findById(enrollmentPayload.getCourseId()));
		enrollmentService.save(enrollment);
	}
	public EnrollmentListJson getStudentIdCardByStudentId(Student student) {
		return EnrollmentListJson.packJson(enrollmentService.findByStudentId(student));
	}
}

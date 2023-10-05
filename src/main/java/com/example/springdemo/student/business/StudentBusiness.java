package com.example.springdemo.student.business;


import com.example.springdemo.student.json.StudentListJson;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.payload.StudentPayload;
import com.example.springdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBusiness {
	@Autowired
	StudentService studentService;
	
	public List<StudentListJson> getListStudent(){
		return StudentListJson.packJsons(studentService.getAllStudents());
	}
	
	public StudentListJson getStudentId(long id) {
		return StudentListJson.packJson(studentService.findById(id));
	}
	
	public StudentListJson getStudentByEmail(String email) {
		return StudentListJson.packJson(studentService.findByEmail(email));
	}
	
	public void saveStudent(StudentPayload studentPayload) {
		Student student = new Student(
						  studentPayload.getFirstName(),
						  studentPayload.getLastName(),
						  studentPayload.getEmail(),
						  studentPayload.getAge());
		studentService.save(student);
	}
	
	public void updateStudent(long id, StudentPayload payload){
		Student studentData = studentService.findById(id);
		studentData.setFirstName(payload.getFirstName());
		studentData.setLastName(payload.getLastName());
		studentData.setEmail(payload.getEmail());
		studentData.setAge(payload.getAge());
		studentService.save(studentData);
	}
	
	public void deleteStudent(long id) {
		studentService.deleteById(id);
	}
}

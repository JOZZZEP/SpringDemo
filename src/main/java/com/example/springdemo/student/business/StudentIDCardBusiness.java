package com.example.springdemo.student.business;

import com.example.springdemo.student.json.StudentIDCardListJson;
import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.model.StudentIdCard;
import com.example.springdemo.student.payload.StudentIDCardPayload;
import com.example.springdemo.student.service.StudentIDCardService;
import com.example.springdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentIDCardBusiness {
	
	@Autowired
	StudentIDCardService studentIdCardService;

	@Autowired
	StudentService studentService;

	public void saveStudentIDCard(StudentIDCardPayload studentIDCardPayload){
		StudentIdCard studentIdCard = new StudentIdCard(
				studentService.findById(studentIDCardPayload.getStudentId()),
				studentIDCardPayload.getCardNumber()
		);
		studentIdCardService.save(studentIdCard);
	}

	public void updateStudentIDCard(long id, StudentIDCardPayload studentIDCardPayload){
		StudentIdCard studentIdCard = studentIdCardService.findById(id);
		studentIdCard.setStudentId(studentService.findById(studentIDCardPayload.getStudentId()));
		studentIdCard.setCardNumber(studentIDCardPayload.getCardNumber());
		studentIdCardService.save(studentIdCard);
	}

	public List<StudentIDCardListJson> getListStudentIdCard(){
		return StudentIDCardListJson.packJsons(studentIdCardService.findAllStudentIdCard());
	}
	
	public StudentIDCardListJson getStudentIdCardByStudentId(Student student) {
		return StudentIDCardListJson.packJson(studentIdCardService.findByStudentId(student));
	}
}

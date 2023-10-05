package com.example.springdemo.student.json;

import com.example.springdemo.student.model.Student;
import com.example.springdemo.student.model.StudentIdCard;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class StudentIDCardListJson {
	private long id;
	private Student student;
	private String cardNumber;
	
	public static StudentIDCardListJson packJson(StudentIdCard studentIdCard){
		StudentIDCardListJson studentIDCardListJson = new StudentIDCardListJson();
		studentIDCardListJson.setId(studentIdCard.getId());
		studentIDCardListJson.setStudent(studentIdCard.getStudentId());
		studentIDCardListJson.setCardNumber(studentIdCard.getCardNumber());
		
		return studentIDCardListJson;
	}
	
	public static List<StudentIDCardListJson> packJsons(List<StudentIdCard> studentIdCards){
		List<StudentIDCardListJson> studentIdCardListJsons = new ArrayList<>();
		for (StudentIdCard studentIdCard : studentIdCards) {
			studentIdCardListJsons.add(packJson(studentIdCard));
		}
		return studentIdCardListJsons;
	}
}

package com.example.springdemo.student.exception;

import com.example.springdemo.exception.BaseException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentException extends BaseException{
    public StudentException(String code, HttpStatus httpStatus){
        super("student." + code, httpStatus);
    }

    public static StudentException emptyStudent(){
        return new StudentException("findStudent.notFound", HttpStatus.BAD_REQUEST);
    }
}

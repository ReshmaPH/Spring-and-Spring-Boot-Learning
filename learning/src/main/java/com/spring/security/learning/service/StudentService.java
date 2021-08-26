package com.spring.security.learning.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.security.learning.model.Student;

@Service
public class StudentService {
	private List<Student> students=Arrays.asList(new Student(1,"Resh"),
			new Student(2,"Sandhu"),
			new Student(3,"Lohi"),
			new Student(4,"Renju"),
			new Student(5,"Rsha"));
	
	public Student getStudent(Integer id) {
		return students.stream()
		.filter(student->id.equals(student.getStudentId()))
		.findFirst()
		.orElseThrow(()-> new IllegalStateException("student "+id+"doesnt exist"));
	}
			

	
	
	

}

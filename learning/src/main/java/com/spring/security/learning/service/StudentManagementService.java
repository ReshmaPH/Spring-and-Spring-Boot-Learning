package com.spring.security.learning.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.spring.security.learning.model.Student;

@Service
public class StudentManagementService {
	
	private List<Student> students=new ArrayList<>(Arrays.asList(new Student(1,"Resh"),
			new Student(2,"Sandhu"),
			new Student(3,"Lohi"),
			new Student(4,"Renju"),
			new Student(5,"Rsha")));

	public List<Student> getAllStudents() {
		return students;
	}

	public void registerNewStudent(Student student) {
		students.add(student);
		
	}

	public void deleteStudent(Integer studentId) {
		 Student student = students.stream().filter(x->studentId.equals(x.getStudentId()))
		.findFirst().get();
		 
		 int indexOf = students.indexOf(student);
		 students.remove(indexOf);
		
	}

	public void updateStudent(Integer studentId, Student student) {
		Student student1=students.stream()
				.filter(x->studentId.equals(x.getStudentId()))
				.findFirst().get();
		
		int indexOf=students.indexOf(student1);
		students.set(indexOf, student);
		
	}
	
	
}

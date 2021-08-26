package com.spring.security.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.learning.model.Student;
import com.spring.security.learning.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping(path="{id}")
	public Student getStudent(@PathVariable Integer id) {
		return studentService.getStudent(id);
	}

}

package com.spring.security.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.learning.model.Student;
import com.spring.security.learning.service.StudentManagementService;


@RestController
@RequestMapping("/management/api/students")
public class StudentMamagementController {
		
	@Autowired
	StudentManagementService studentManaementService;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMINTRAINEE','ROLE_ADMIN')")
	public List<Student> getAllStudents(){
		return studentManaementService.getAllStudents();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void registerNewStudent(@RequestBody Student student) {
		studentManaementService.registerNewStudent(student);
	}
	
	@DeleteMapping(path="{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public void deleteStudent(@PathVariable Integer studentId) {
		studentManaementService.deleteStudent(studentId);
	}
	
	@PutMapping(path="{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student) {
		studentManaementService.updateStudent(studentId,student);
	}
	
}

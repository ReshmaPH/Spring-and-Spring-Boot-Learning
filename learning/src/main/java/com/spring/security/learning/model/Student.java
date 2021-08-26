package com.spring.security.learning.model;

public class Student {
	private Integer studentId;
	private String studentName;
	
	
	
	public Student(Integer studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	
}


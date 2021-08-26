package com.spring.security.learning.jwt;

public class UsernamePasswordAuthenticationRequest {
	String username;
	String password;
	
	public UsernamePasswordAuthenticationRequest() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};
	
	
}

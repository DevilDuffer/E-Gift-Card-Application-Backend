package com.cg.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserLogin {

	@NotEmpty
	@Email(message="Email Address is not Valid!")
	private String email;
	@NotEmpty
	private String password;
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserLogin [email=" + email + ", password=" + password + "]";
	}
	
}
package com.cg.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogin {

	@NotEmpty
	@Email(message = "Email Address is not Valid!")
	private String email;

	@NotEmpty
	private String password;
}
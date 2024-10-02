package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.entity.UserLogin;
import com.cg.exception.UserNotFoundException;
import com.cg.services.UserManagementService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserRegistrationController {

	@Autowired
	UserManagementService userServices;

	@PostMapping("/add")
	public String addUser(@Valid @RequestBody User userRegistration) {
		System.out.println(userRegistration);
		userServices.saveOrUpdate(userRegistration);
		return "User Registered Successfully";
	}

	@GetMapping("/getAll")
	public List<User> getAllUser() {
		return userServices.getAll();
	}

	@GetMapping("/searchByEmail/{email}")
	public User getByEmailee(@PathVariable("email") String email) throws UserNotFoundException {
		return userServices.getByEmail(email);
	}

	@PostMapping("/Login")
	public String loginUser(@Valid @RequestBody UserLogin userLogin) {
		if (userServices.getByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword()) == null) {
			return "Invalid Credentials";
		} else {
			return "Logged In Successfully";
		}
	}

	@PutMapping("/changePassword")
	public String changePassword(@Valid @RequestBody UserLogin userLogin) throws UserNotFoundException {
		User u = userServices.getByEmail(userLogin.getEmail());
		u.setPassword(userLogin.getPassword());
		userServices.saveOrUpdate(u);
		return "Password Changed Successfully";
	}
}

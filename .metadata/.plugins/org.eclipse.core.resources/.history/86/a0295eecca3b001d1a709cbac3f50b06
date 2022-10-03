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

import com.cg.entity.UserLogin;
import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.services.UserManagementService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserRegistrationController {

	@Autowired
	UserManagementService userServices;
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	GiftCardRepository giftCardRepository;
	
	
	
	@PostMapping("/add")
	public String addUser(@Valid @RequestBody User userRegistration) {
		System.out.println(userRegistration);
		userServices.saveOrUpdate(userRegistration);
		return "User Registered Successfully";
		}
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return userServices.getAll();
	}
	
	
	// Search by UserName,UserEmail Controller
	
	
	@GetMapping("/searchByFirstname/{fname}")
	public List<User> getByFirstnamee(@PathVariable("fname") String fname) throws UserNotFoundException {
		return userServices.getByFirstname(fname);
	}
	@GetMapping("/searchByLastname/{lname}")
	public List<User> getByLastnamee(@PathVariable("lname") String lname) throws UserNotFoundException {
		return userServices.getByLastname(lname);
	}
	@GetMapping("/searchByEmail/{email}")
	public User getByEmailee(@PathVariable("email") String email) throws UserNotFoundException {
		return userServices.getByEmail(email);
	}
	
	
	//Login and Change Password Controller
	
	@PostMapping("/Login")
	public String loginUser(@Valid @RequestBody UserLogin userLogin) {
		if(userServices.getByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword())==null)
			return "Invalid Credentials";
		else
			return "Logged In Successfully";
		
		}
	@PutMapping("/changePassword")
	public String changePassword(@Valid @RequestBody UserLogin userLogin) throws UserNotFoundException {
		User u = userServices.getByEmail(userLogin.getEmail());
		u.setPassword(userLogin.getPassword());
		userServices.saveOrUpdate(u);
		return "Password Changed Successfully";
		
		}

//	//Mapping Controller for user and giftcardtable
//	 @PutMapping("/{id}/gifts/{giftcardId}")
//	    User addGiftCardToUser(
//	            @PathVariable int id,
//	            @PathVariable int giftCardId
//	    ) {
//	        User user = userRepository.findById(id).get();
//	        GiftCard giftCard = giftCardRepository.findById(giftCardId).get();
//	        user.gifts.add(giftCard);
//	        return userRepository.save(user);
//	    }
//	
}

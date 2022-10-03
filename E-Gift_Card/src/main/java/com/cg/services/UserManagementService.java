package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.UserRepository;

@Service
public class UserManagementService {
	@Autowired 
	UserRepository userRepository;
	public String saveOrUpdate(User userRegistration) {
		userRepository.save(userRegistration);
		return "User Registered Successfully";
	}
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	

	public List<User> getByFirstname(String fname) throws UserNotFoundException {
		try {
			if(userRepository.findByFirstname(fname).isEmpty())
				throw new UserNotFoundException();
		}
			catch(UserNotFoundException e) {
				throw e;
			}
		
	    return  userRepository.findByFirstname(fname);
	}
    public List<User> getByLastname(String lname) throws UserNotFoundException {
		try {
			if(userRepository.findByLastname(lname).isEmpty())
				throw new UserNotFoundException();
		}
		catch(UserNotFoundException e) {
			throw e;
		}
	    return  userRepository.findByLastname(lname);
	} 
    public User getByEmail(String email) throws UserNotFoundException {
		try {
			if(userRepository.findByEmail(email)==null)
				throw new UserNotFoundException();
		}
		catch(UserNotFoundException e) {
			throw e;
		}
	    return  userRepository.findByEmail(email);
	} 
    public User getByEmailAndPassword(String email,String password) {
    	
    	return userRepository.findByEmailAndPassword(email, password);
    }
    
}

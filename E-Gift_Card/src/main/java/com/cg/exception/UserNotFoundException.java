package com.cg.exception;

public class UserNotFoundException extends Exception {
	
	public String toString(UserNotFoundException e) {
		
		return "User Not Found";
	}
}

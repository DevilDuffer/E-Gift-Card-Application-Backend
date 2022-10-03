package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	public List <User> findByFirstname(String fname);
	public List <User> findByLastname(String lname);
	public  User findByEmail(String email);
	public User findByEmailAndPassword(String email,String password);
}

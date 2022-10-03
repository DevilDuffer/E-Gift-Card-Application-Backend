package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.UserGiftDetails;
import com.cg.exception.UserGiftDetailsNotFoundException;
import com.cg.services.UserGiftDetailsAccountManagementServices;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserGiftDetailsController {

	@Autowired
	UserGiftDetailsAccountManagementServices userGiftDetailsServices;
	@PostMapping("/generateGift")
	public String generateGift(@Valid @RequestBody UserGiftDetails userGiftDetails) {
		userGiftDetailsServices.saveOrUpdate(userGiftDetails);
		return "Gift Send Successfully";
	}
	
	@GetMapping("/getAllGeneratedGifts")
	public List<UserGiftDetails> getAll(){
		return userGiftDetailsServices.getAll();	
		}
	
	@GetMapping("/getAllGeneratedGifts/{userGiftId}")
	public UserGiftDetails getByUserGiftId(@PathVariable("userGiftId") int userGiftId) throws UserGiftDetailsNotFoundException {
		return userGiftDetailsServices.getByUserGiftId(userGiftId);
	}
	@DeleteMapping("/deleteGeneratedGift/{userGiftId}")
	public String deleteByUserGiftId(@PathVariable("userGiftId") int userGiftId) throws UserGiftDetailsNotFoundException {
		userGiftDetailsServices.deleteByUserGiftDetailsId(userGiftId);
		return "Generated Gift Deleted Successfully";
	}
	
}


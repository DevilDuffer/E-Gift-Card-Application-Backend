package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.GiftRecdDetails;
import com.cg.entity.UserGiftDetails;
import com.cg.exception.UserNotFoundException;
import com.cg.services.GiftRecdServices;
import com.cg.services.UserGiftDetailsAccountManagementServices;
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class GiftRecdController {

	@Autowired
	GiftRecdServices giftRecdServices;
	
	
	@PostMapping("/receivedDetails")
	public String addUser(@Valid @RequestBody GiftRecdDetails giftRecdDetails) {
		giftRecdServices.saveOrUpdate(giftRecdDetails);
		return "Gift Recd Details";
		}
	
	@GetMapping("/getAllRecdDetails")
	public List<GiftRecdDetails> getAllUser(){
		return giftRecdServices.getAll();
	}
	@PostMapping("/receiveGift")
	public String receivedGift(@Valid @RequestBody UserGiftDetails userGiftDetails) throws UserNotFoundException {
		giftRecdServices.receivedGift(userGiftDetails);
		return "Gift received Successfully";
	}
}

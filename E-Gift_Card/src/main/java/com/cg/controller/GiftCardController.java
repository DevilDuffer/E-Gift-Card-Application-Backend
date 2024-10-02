package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.GiftCard;
import com.cg.entity.User;
import com.cg.exception.GiftCardNotFoundException;
import com.cg.exception.UserNotFoundException;
import com.cg.services.GiftCardManagementServices;
import com.cg.services.UserManagementService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GiftCardController {

	@Autowired
	GiftCardManagementServices giftCardServices;

	@Autowired
	UserManagementService userServices;

	@PostMapping("/giftCard/{email}")
	public String addUser(@Valid @RequestBody GiftCard giftCard, @PathVariable String email)
			throws UserNotFoundException {
		User user = userServices.getByEmail(email);
		user.addGiftCard(giftCard);
		giftCardServices.saveOrUpdateGiftCard(giftCard);
		return "Gift Card Added Successfully";
	}

	@GetMapping("/getAllGiftCard")
	public List<GiftCard> getAll() {
		return giftCardServices.getAll();
	}

	@GetMapping("/searchByGiftCardName/{giftCardName}")
	public List<GiftCard> getByFirstnamee(@PathVariable("giftCardName") String giftCardName)
			throws GiftCardNotFoundException {
		return giftCardServices.getByGiftCardName(giftCardName);
	}

}

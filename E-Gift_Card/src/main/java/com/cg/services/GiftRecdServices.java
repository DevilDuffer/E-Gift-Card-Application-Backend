package com.cg.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.GiftCard;
import com.cg.entity.GiftRecdDetails;
import com.cg.entity.User;
import com.cg.entity.UserGiftDetails;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.GiftCardRepository;
import com.cg.repository.GiftRecdRepository;

@Service
public class GiftRecdServices {

	@Autowired
	GiftRecdRepository giftRecdRepository;
	@Autowired
	UserManagementService userServices;
	@Autowired
	GiftCardManagementServices giftCardServices;
	@Autowired
	GiftCardRepository giftCardRepository;

	public String saveOrUpdate(GiftRecdDetails giftRecdDetails) {
		giftRecdRepository.save(giftRecdDetails);
		return "Gift Recd Details";
	}

	public List<GiftRecdDetails> getAll() {
		return giftRecdRepository.findAll();
	}

	public String receivedGift(UserGiftDetails userGiftDetails) throws UserNotFoundException {
		String email = userGiftDetails.getRecipientsEmail();
		User user = userServices.getByEmail(email);
		GiftCard giftcard = giftCardRepository.findById(userGiftDetails.getGiftCardId()).orElse(null);
		GiftRecdDetails recdDetails = new GiftRecdDetails();
		recdDetails.setUser(user);
		recdDetails.setGift(giftcard);
		recdDetails.setGiftReceivedDate(new Date(System.currentTimeMillis()));
		giftRecdRepository.save(recdDetails);
		return "Gift Received Successfully";
	}
}

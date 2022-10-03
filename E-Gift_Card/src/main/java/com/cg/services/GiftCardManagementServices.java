package com.cg.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.GiftCard;
import com.cg.exception.GiftCardNotFoundException;
import com.cg.repository.GiftCardRepository;

@Service
public class GiftCardManagementServices {

	@Autowired 
	GiftCardRepository giftCardRepository;
	public String saveOrUpdateGiftCard(GiftCard giftCard) {
		giftCardRepository.save(giftCard);
		return "GiftCard Added Successfully";
	}
	
	public List<GiftCard> getAll() {
		return giftCardRepository.findAll();
	}
	
	
	
	
	public List<GiftCard> getByGiftCardName(String giftCardName) throws GiftCardNotFoundException{
		try {
			if(giftCardRepository.findByGiftCardName(giftCardName).isEmpty())
				throw new GiftCardNotFoundException();
		}
		catch(GiftCardNotFoundException e) {
		    throw e;
		}
		return giftCardRepository.findByGiftCardName(giftCardName);
	}
	
	
}

package com.cg.controller;

import java.util.ArrayList;
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
@CrossOrigin(origins="http://localhost:3000")
public class GiftCardController {

	@Autowired
	GiftCardManagementServices giftCardServices;
	@Autowired UserManagementService userServices;
	
	@PostMapping("/giftCard/{email}")
	public String addUser(@Valid @RequestBody GiftCard giftcard,@PathVariable String email) throws UserNotFoundException {
		System.out.println(email);
		User user = userServices.getByEmail(email);
		List<User> userr=new ArrayList();
		userr.add(user);
		giftcard.setUsers(userr);
		giftCardServices.saveOrUpdateGiftCard(giftcard);
		return "Gift Card Added Successfully";
		}
	
	@GetMapping("/getAllGiftCard")
	public List<GiftCard> getAll(){
		
		return giftCardServices.getAll();
	}
	
//	@GetMapping("/getAllGiftCar/{email}")
//	public List<GiftCard> getAllByUserEmail(@PathVariable String email){
//		System.out.println(email);
//		List<GiftCard> giftemail=new ArrayList<GiftCard>();
//		List<GiftCard> giftCard=new ArrayList<GiftCard>();
//		giftCard= giftCardServices.getAll();
////		for(GiftCard x:giftCard) {
////			System.out.println(x);
////		}
//		//System.out.println(giftCard);
//		for(GiftCard x:giftCard) {
//			List<User> user=x.getUsers();
//			if(user.get(0).getEmail()==email) {
//				giftemail.add(x);
//			}
//		}
//		return gift();
//	}
	
	@GetMapping("/searchByGiftCardName/{giftCardName}")
	public List<GiftCard> getByFirstnamee(@PathVariable("giftCardName") String giftCardName) throws GiftCardNotFoundException {
		return giftCardServices.getByGiftCardName(giftCardName);
	}
	
}

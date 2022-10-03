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

import com.cg.entity.UserPayment;
import com.cg.exception.PaymentNotFoundException;
import com.cg.services.UserPaymentServices;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserPaymentController {
	
	@Autowired
	UserPaymentServices userPaymentServices;
	@PostMapping("/addpayment")
	public String addPayment(@Valid @RequestBody UserPayment userPayment) throws PaymentNotFoundException{
		userPaymentServices.saveOrUpdate(userPayment);
		return "User Payment Sucessfully";
		}
	
	@GetMapping("/getAllpayement")
	public List<UserPayment> getAllUserPayment() throws PaymentNotFoundException{
		return userPaymentServices.getAll();
		}
	
	@GetMapping("/getByNameonTheCard/{card_name}")
	public List<UserPayment> getByNameonthecard(@PathVariable("card_name") String card_name) throws PaymentNotFoundException{
		return userPaymentServices.getByNameonthecard(card_name);
	}


	@GetMapping("/getByCardNumber/{cardNumber}")
	public UserPayment getByCardnumber(@PathVariable("cardNumber") String cardNumber) throws PaymentNotFoundException {
		return userPaymentServices.getByCardnumber(cardNumber);
	}
	
	@GetMapping("/getByUserGiftId/{gift_id}")
	public UserPayment getByUserGiftId(@PathVariable("gift_id")int gift_id) throws PaymentNotFoundException{
	return userPaymentServices.getByUserGiftId(gift_id);
		
	}
	
	
	@DeleteMapping("/deletePaymentById/{paymentid}")
	public String deleteById(@PathVariable("paymentid") int paymentid) throws PaymentNotFoundException {
		userPaymentServices.deleteUserPaymentById(paymentid);
		return "Payment Details Removed Successfully";
	}
	
	
    
	
	
	

}

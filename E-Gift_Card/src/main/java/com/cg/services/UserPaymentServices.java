package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.UserPayment;
import com.cg.exception.PaymentNotFoundException;
import com.cg.repository.PaymentRepository;



@Service
public class UserPaymentServices {
	
	@Autowired
	PaymentRepository paymentRepository;
	public String saveOrUpdate(UserPayment userPayment) {
		paymentRepository.save(userPayment);
		return "User Payment Sucessfully";
		
	}
	
	public List<UserPayment> getAll(){
		return paymentRepository.findAll();
	}
	
	
	
	public List <UserPayment> deleteAll() {
		paymentRepository.deleteAll();
		return null;
	}
	

	public void deleteUserPaymentById(int paymentid) {
		 paymentRepository.deleteById(paymentid);
	}
	
	public UserPayment getByCardnumber(String cardNumber)throws PaymentNotFoundException{
		try {
			if(paymentRepository.findByCardNumber(cardNumber)==null)
				throw new PaymentNotFoundException();
		}
		catch(PaymentNotFoundException e) {
			throw e;
		}
		return paymentRepository.findByCardNumber(cardNumber);
		
	}
	public List<UserPayment> getByNameonthecard(String card_name)throws PaymentNotFoundException{
		try {
			if(paymentRepository.findByNameonthecard(card_name).isEmpty())
				throw new PaymentNotFoundException();
		}
		catch(PaymentNotFoundException e) {
			throw e;
		}
		return paymentRepository.findByNameonthecard(card_name);
		
	}

	
	
	public UserPayment getByUserGiftId(int  gift_id)throws PaymentNotFoundException{
		try {
			if(paymentRepository.findByUserGiftId( gift_id)==null)
				throw new PaymentNotFoundException();
		}
		catch(PaymentNotFoundException e) {
			throw e;
		}
		return paymentRepository.findByUserGiftId( gift_id);
		
	}

	
	
}

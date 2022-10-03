package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.UserPayment;

@Repository
public interface PaymentRepository extends JpaRepository<UserPayment,Integer> {
	public  UserPayment findByCardNumber(String cardNumber);
	public List <UserPayment> findByNameonthecard(String card_name);
	
	public UserPayment findByUserGiftId(int gift_id);

	

}

package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.entity.GiftCard;

@Repository
public interface GiftCardRepository extends JpaRepository<GiftCard,Integer> {

	public List <GiftCard> findByGiftCardName(String giftCardName);
}


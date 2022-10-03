package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.UserGiftDetails;

@Repository
public interface UserGiftDetailsRepository extends JpaRepository<UserGiftDetails,Integer> {

	public UserGiftDetails findByUserGiftId(int userGiftId);

	public void deleteByUserGiftId(int userGiftId);

}

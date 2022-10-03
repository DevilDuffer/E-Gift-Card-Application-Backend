package com.cg.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.UserGiftDetails;
import com.cg.exception.UserGiftDetailsNotFoundException;
import com.cg.repository.UserGiftDetailsRepository;

@Service
@Transactional
public class UserGiftDetailsAccountManagementServices {
	
	@Autowired
	UserGiftDetailsRepository userGiftDetailsRepository;
	public String saveOrUpdate(UserGiftDetails userGiftDetails) {
		userGiftDetailsRepository.save(userGiftDetails);
		return "User Gift Details Added Successfully";
	}
	
	public List<UserGiftDetails> getAll() {
		return userGiftDetailsRepository.findAll();
	}
	
	public UserGiftDetails getByUserGiftId(int userGiftId) throws UserGiftDetailsNotFoundException {
		try {
			if(userGiftDetailsRepository.findByUserGiftId(userGiftId)==null)
				throw new UserGiftDetailsNotFoundException();
		}
			catch(UserGiftDetailsNotFoundException e) {
				throw e;
			}			    return  userGiftDetailsRepository.findByUserGiftId(userGiftId);
	}

	public String deleteByUserGiftDetailsId(int userGiftId) throws UserGiftDetailsNotFoundException {
		try {
			if(userGiftDetailsRepository.findByUserGiftId(userGiftId)==null)
				throw new UserGiftDetailsNotFoundException();
		}
			catch(UserGiftDetailsNotFoundException e) {
				throw e;
			}
		userGiftDetailsRepository.deleteByUserGiftId(userGiftId);
		return "Generated Gift Deleted Successfully";
	}
	
	
//	List<UserGiftDetails> getAllUser_Gift_details();
//	
//	UserGiftDetails getUser_Gift_details(int User_Gift_detailsId);
//	
//	UserGiftDetails addUser_Gift_details(UserGiftDetails User_Gift_details);
//	UserGiftDetails UpdateUser_Gift_details(UserGiftDetails User_Gift_details);
//	UserGiftDetails UpdateUser_Gift_detailsById(int userGiftDetailsId);
//	String deleteUser_Gift_details(UserGiftDetails userGiftDetails);
//	String deleteUser_Gift_detailsById(int userGiftDetailsId);
}

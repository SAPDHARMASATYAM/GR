package com.gateranker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.User;
/**
 * @author Sap Dharma Satyam
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UserService {

	User userLogin(String emailId, String password);

	List<User> getUsersByActiveIndicator(Boolean active);

	int updatePasswordByEmailId(String password, String emailId);

	User getUserByEmailIdId(String emailId);

	User registerUser(User user);
	
	public List<User> getAllUsers();

}
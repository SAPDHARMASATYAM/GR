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

	public User userLogin(String emailId, String password);

	public List<User> getUsersByActiveIndicator(Boolean active);

	public int updatePasswordByEmailId(String password, String emailId);

	public User getUserByEmailIdId(String emailId);

	public User registerUser(User user);

	public List<User> getAllUsers();

	public String getUserFullNameByUserName(String userName);

	public Boolean removeUserByUserName(String userName);

}
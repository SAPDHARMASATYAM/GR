package com.gateranker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.User;
import com.gateranker.jpa.repository.UserRepository;

/**
 * @author Sap Dharma Satyam
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceBean implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User userLogin(String emailId, String password) {
		User loginResponse = userRepository.findByUserNameAndPassword(emailId, password);
		return loginResponse;
	}

	@Override
	public List<User> getUsersByActiveIndicator(Boolean active){
		return userRepository.findAll();
	}
	@Override
	public int updatePasswordByEmailId(String password, String emailId) {
		return 0;//userRepository.updatePasswordByEmailId(password, emailId);
	}

	@Override
	public User getUserByEmailIdId(String emailId) {
		return userRepository.findById(emailId).get();
	}
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}

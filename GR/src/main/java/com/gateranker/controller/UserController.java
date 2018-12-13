package com.gateranker.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.jpa.model.User;
import com.gateranker.service.UserService;
/**
 * @author Sap Dharma Satyam
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUserByUserId/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> getUserByUserId(@PathVariable(name="emailId") String emailId) throws Exception {
		
		 User userByEmailIdIdResponse = userService.getUserByEmailIdId(emailId);
		 
		 return null!=userByEmailIdIdResponse? new ResponseEntity<User>(userByEmailIdIdResponse, HttpStatus.OK):new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getAllUsers() throws Exception {
		return userService.getAllUsers();
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public User login(@RequestBody User user) throws Exception {
		return userService.userLogin(user.getUserName(), user.getPassword());
	}
	
	@RequestMapping(value = "/getUsersByActiveIndicator/{active}", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsersByActiveIndicator(@PathVariable(name="active") Boolean active) throws Exception {
		return userService.getUsersByActiveIndicator(active);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public User register(@RequestBody User user) throws Exception {
		user.setDateOfRegistration(new Date());
		user.setLastLoginDate(new Date());
		user.setInvalidAttemptCount(0);
		return userService.registerUser(user);
	}
}
package com.gateranker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.entity.User;
import com.gateranker.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUserByUserId/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public User getUserByUserId(@PathVariable(name="emailId") String emailId) throws Exception {
		return userService.getUserByEmailIdId(emailId);
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getAllUsers() throws Exception {
		return userService.getAllUsers();
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public User login(@RequestBody User user) throws Exception {
		return userService.userLogin(user.getEmailId(), user.getPassword());
	}
	
	@RequestMapping(value = "/getUsersByActiveIndicator/{active}", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsersByActiveIndicator(@PathVariable(name="active") Boolean active) throws Exception {
		return userService.getUsersByActiveIndicator(active);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public User register(@RequestBody User user) throws Exception {
		return userService.registerUser(user);
	}
}
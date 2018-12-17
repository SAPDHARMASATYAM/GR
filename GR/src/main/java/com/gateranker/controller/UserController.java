package com.gateranker.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.Constants;
import com.gateranker.dto.Response;
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
	public Response getUserByUserId(@PathVariable(name = "emailId") String emailId) {
		Response response = new Response();
		try {
			User userByEmailIdIdResponse = userService.getUserByEmailIdId(emailId);
			if(null != userByEmailIdIdResponse) {
			response.setResponseStatus(Constants.SUCCESS);
			response.setResponseMessage("User found by given mailid");
			response.setResponseContent(userByEmailIdIdResponse);
			}else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage("User not fout with given user name and password");
				response.setResponseContent(userByEmailIdIdResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
		}
		return response;
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public Response getAllUsers() throws Exception {

		List<User> allUsers = userService.getAllUsers();
		Response response = new Response();
		response.setResponseMessage("User found by given mailid");
		response.setResponseStatus(Constants.SUCCESS);
		response.setResponseContent(allUsers);
		return response;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public Response login(@RequestBody User user) throws Exception {
		User userLoginResponse = userService.userLogin(user.getUserName(), user.getPassword());
		Response response = new Response();
		response.setResponseMessage("Login successful");
		response.setResponseStatus(Constants.SUCCESS);
		response.setResponseContent(userLoginResponse);
		return response;
	}

	@RequestMapping(value = "/getUsersByActiveIndicator/{active}", method = RequestMethod.GET, produces = "application/json")
	public Response getUsersByActiveIndicator(@PathVariable(name = "active") Boolean active) throws Exception {
		List<User> usersByActiveIndicator = userService.getUsersByActiveIndicator(active);
		Response response = new Response();
		response.setResponseMessage("Login successful");
		response.setResponseStatus(Constants.SUCCESS);
		response.setResponseContent(usersByActiveIndicator);
		return response;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public Response register(@RequestBody User user) throws Exception {
		Response response = new Response();
		user.setDateOfRegistration(new Date());
		user.setLastLoginDate(new Date());
		user.setInvalidAttemptCount(0);
		response.setResponseStatus(Constants.SUCCESS);
		response.setResponseMessage("Registration Successfull");
		response.setResponseContent(user);
		return response;
	}
}
/**
 * 
 */
package com.gateranker.service;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gateranker.jpa.model.User;

/**
 * @author satyanarayanakondaparthi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	static User user;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user =new User();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		user.setUserName("satyam@mail.com");
		user.setPassword("password");
		user.setFirstName("Satyam");
		user.setLastName("Kondaparthy");
		user.setLastLoginDate(new Date());
		user.setDateOfRegistration(new Date());
		User registerUser = userService.registerUser(user);
		System.err.println("Registration response ::::::::::: \n" + registerUser);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		userService.removeUserByUserName(user.getUserName());
		System.err.println("user deleted successfully :::::::::::::::::::::::::::::::::");
	}

	@Test
	public void test() {
		User user = new User();
		user.setUserName("satyam@mail.com");
		System.err.println("USer full name : " + userService.getUserFullNameByUserName(user.getUserName()));
		System.err.println("All Users Data ::::::::::::::::::::::::::: \n"+userService.getAllUsers());
	}

}

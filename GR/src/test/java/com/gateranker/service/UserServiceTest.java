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

import com.gateranker.entity.User;

/**
 * @author satyanarayanakondaparthi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		User user =new User();
		user.setEmailId("abc@mail.com");
		user.setPassword("password");
		user.setLastLogin(new Date());
		user.setDatOfRegistration(new Date());
		user.setNew(true);
		User registerUser = userService.registerUser(user);
		System.out.println("Registration response ::::::::::: \n" + registerUser);
		System.out.println("All Users Data ::::::::::::::::::::::::::: \n"+userService.getAllUsers());
	}

}
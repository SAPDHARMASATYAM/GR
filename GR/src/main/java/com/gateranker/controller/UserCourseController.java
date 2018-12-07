/**
 * 
 */
package com.gateranker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.jpa.model.UserCourse;
import com.gateranker.service.UserCourseService;

/**
 * @author Sap Dharma Satyam
 *
 */
@RestController
@RequestMapping("userCourse")
public class UserCourseController {

	@Autowired
	private UserCourseService userCourseService;

	@PostMapping(value = "addCourseToUser", produces = "application/json")
	public Boolean addCourseToUser(@Valid @RequestBody UserCourse userCourse) throws Exception {
		return userCourseService.addCourseToUser(userCourse);
	}

	@PutMapping(value = "updateCourseOfUser/{userName}/{userName}/{newCourse}", produces = "application/json")
	public Boolean updateCourseOfUser(@PathVariable(name = "userName", required = true) String userName,
			@PathVariable(name = "oldCourse", required = true) String oldCourse,
			@PathVariable(name = "newCourse", required = true) String newCourse) {
		return userCourseService.updateCourseOfUser(userName, oldCourse, newCourse);
	}

	@DeleteMapping(value = "removeCourseFromUser/{userName}/{courseId}")
	public Boolean removeCourseFromUser(@PathVariable(name = "userName", required = true) String userName,
			@PathVariable(name = "courseId", required = true) String courseId) {
		return userCourseService.removeCourseFromUser(userName, courseId);
	}

	@DeleteMapping(value = "removeAllCoursesFromUser/{userName}")
	public Boolean removeAllCoursesFromUser(@PathVariable(name = "userName", required = true) String userName) {
		return userCourseService.removeAllCoursesFromUser(userName);
	}

	@GetMapping(value = "getAllCoursesOfUser/{userName}")
	public List<UserCourse> getAllCoursesOfUser(@PathVariable(name = "userName", required = true) String userName) {
		return userCourseService.getAllCoursesOfUser(userName);
	}

	@GetMapping(value = "getAllCoursesOfUserByActiveIndicator/{userName}/{activeIndicator}")
	public List<UserCourse> getAllCoursesOfUserByActiveIndicator(
			@PathVariable(name = "userName", required = true) String userName,
			@PathVariable(name = "activeIndicator", required = true) Boolean activeIndicator) {
		return userCourseService.getAllCoursesOfUserByActiveIndicator(userName, activeIndicator);
	}

	@PutMapping(value = "enableOrDisableCourseOfUser/{userName}/{userName}/{courseId}/{activeIndicator}", produces = "application/json")
	public Boolean enableOrDisableCourseOfUser(@PathVariable(name = "userName", required = true) String userName,
			@PathVariable(name = "courseId", required = true) String courseId,
			@PathVariable(name = "activeIndicator", required = true) Boolean activeIndicator) {
		return userCourseService.enableOrDisableCourseOfUser(userName, courseId, activeIndicator);
	}

	@PutMapping(value = "enableOrDisableAllCoursesOfUser/{userName}/{userName}/{activeIndicator}", produces = "application/json")
	public Boolean enableOrDisableAllCoursesOfUser(@PathVariable(name = "userName", required = true) String userName,
			@PathVariable(name = "activeIndicator", required = true) Boolean activeIndicator) {
		return userCourseService.enableOrDisableAllCoursesOfUser(userName, activeIndicator);
	}

}

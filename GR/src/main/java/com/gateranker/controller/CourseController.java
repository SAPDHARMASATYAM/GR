package com.gateranker.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.Constants;
import com.gateranker.dto.Response;
import com.gateranker.jpa.model.Course;
import com.gateranker.service.CourseService;
/**
 * @author Sap Dharma Satyam
 */
@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping(value = "getAllCourses")
	public Response getAllCourses() throws Exception {
		Response response = new Response();
		try {
			List<Course> allCourses = courseService.getAllCourses();
			if(null != allCourses) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage("Available courses count : " + allCourses.size());
				response.setResponseContent(allCourses);
			}
			else {
				response.setResponseStatus(Constants.NO_DATA);
				response.setResponseMessage("No Data Found");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping(value = "getAllActiveCourses")
	public Response getAllActiveCourses() throws Exception {
		Response response = new Response();
		try {
			List<Course> allActiveCourses = courseService.getAllActiveCourses();
			if(null != allActiveCourses) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage("Available Active courses count : " + allActiveCourses.size());
				response.setResponseContent(allActiveCourses);
			}
			else {
				response.setResponseStatus(Constants.NO_DATA);
				response.setResponseMessage("No Data Found");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping(value = "getAllInActiveCourses")
	public Response getAllInActiveCourses() throws Exception {
		Response response = new Response();
		try {
			List<Course> allInActiveCourses = courseService.getAllInActiveCourses();
			if(null != allInActiveCourses) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage("Available InActive courses count : " + allInActiveCourses.size());
				response.setResponseContent(allInActiveCourses);
			}
			else {
				response.setResponseStatus(Constants.NO_DATA);
				response.setResponseMessage("No Data Found");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping(value = "addCourse")
	public Response addCourse(@RequestBody Course course) throws Exception {
		Response response = new Response();
		try {
			Course addCourseResponse = courseService.addCourse(course);
			if(null != addCourseResponse) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage("Course adding successfull!");
				response.setResponseContent(addCourseResponse);
			}
			else {
				response.setResponseStatus(Constants.NO_DATA);
				response.setResponseMessage("No Data Found");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();
		}
		return response;
	}

	@PutMapping("enableOrDisableCourse/{flag}")
	public Response enableOrDisableCourse(@PathVariable(name = "flag") Boolean flag,
			@Valid @RequestBody Course course) {
		Response response = new Response();
		try {
		 Optional<Course> eodResponse = courseService.findById(course.getId()).map(c -> {
				Course enableOrDisableCourse = courseService.enableOrDisableCourse(c, flag);
				return enableOrDisableCourse;
			});
			if(flag == eodResponse.get().getIsCourseActive()) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(course.getCourseName() + "'s enable status is : " + flag);
				response.setResponseContent(course);
			}
			else {
				response.setResponseStatus(Constants.NO_DATA);
				response.setResponseMessage("No course found with given course details");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();
		}
		return response;
	}

}

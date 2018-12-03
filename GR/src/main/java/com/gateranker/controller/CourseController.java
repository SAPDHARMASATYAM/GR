package com.gateranker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.jpa.exception.ResourceNotFoundException;
import com.gateranker.jpa.model.Course;
import com.gateranker.service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping(value = "getAllCourses")
	public List<Course> getAllCourses() throws Exception {
		return courseService.getAllCourses();
	}

	@GetMapping(value = "getAllActiveCourses")
	public List<Course> getAllActiveCourses() throws Exception {
		return courseService.getAllActiveCourses();
	}

	@GetMapping(value = "getAllInActiveCourses")
	public List<Course> getAllInActiveCourses() throws Exception {
		return courseService.getAllInActiveCourses();
	}

	@PostMapping(value = "addCourse")
	public Course addCourse(@RequestBody Course course) throws Exception {
		return courseService.addCourse(course);
	}

	@PutMapping("enableOrDisableCourse/{flag}")
	public ResponseEntity<?> enableOrDisableCourse(@PathVariable(name = "flag") Boolean flag,
			@Valid @RequestBody Course course) {
		return courseService.findById(course.getId()).map(c -> {
			courseService.enableOrDisableCourse(c, flag);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("course :  " + course.getId() + " not found"));
	}

}

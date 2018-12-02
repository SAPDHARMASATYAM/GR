package com.gateranker.service;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gateranker.jpa.model.Course;
/**
 * @author satyanarayanakondaparthi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

	@Autowired
	private CourseService courseService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Course course = new Course();
		course.setCourseName("CSC");
		course.setDateOfCourseRegistration(new Date());
		course.setIsCourseActive(true);
		Course addCourseResponse = courseService.addCourse(course);
		System.out.println("addCourseResponse ::: \n"+addCourseResponse);
		Course course2 = new Course();
		course2.setCourseName("EEE");
		course2.setDateOfCourseRegistration(new Date());
		course2.setIsCourseActive(false);
		addCourseResponse = courseService.addCourse(course2);
		System.out.println("addCourseResponse ::: \n"+addCourseResponse);
		System.err.println("All courses :::::::: \n "+ courseService.getAllCourses());
		List<Course> allActiveCourses = courseService.getAllActiveCourses();
		System.err.println("All Active courses :::::::: \n "+ allActiveCourses);
		 List<Course> allInActiveCourses = courseService.getAllInActiveCourses();
		System.err.println("All InActive courses :::::::: \n "+allInActiveCourses);
		for(Course c:allActiveCourses) {
			courseService.enableOrDisableCourse(c, false);
		}
		for(Course c: allInActiveCourses) {
			courseService.enableOrDisableCourse(c, true);
		}
		allActiveCourses = courseService.getAllActiveCourses();
		System.err.println("All Active courses :::::::: \n "+ allActiveCourses);
		allInActiveCourses = courseService.getAllInActiveCourses();
		System.err.println("All InActive courses :::::::: \n "+allInActiveCourses);
	}

}

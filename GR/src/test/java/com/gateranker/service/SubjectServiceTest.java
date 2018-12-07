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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gateranker.jpa.model.Subject;

/**
 * @author satyanarayanakondaparthi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectServiceTest {

	@Autowired
	private SubjectService subjectservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Subject subject = new Subject();
		subject.setDateOfSubjectRegistration(new Date());
		subject.setIsSubjectActive(true);
		subject.setSubjectName("Data structures");
		Subject addSubjectResponse;
		try {
			addSubjectResponse = subjectservice.addSubject(subject);
			System.out.println("addSubjectResponse ::::: \n" + addSubjectResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		
		ResponseEntity<?> removeSubject = subjectservice.removeSubject("Data structures");
		System.err.println(removeSubject.toString());
		
	}

	@Test
	public void test() throws Exception {
		Subject subject = new Subject();
		subject.setDateOfSubjectRegistration(new Date());
		subject.setIsSubjectActive(false);
		subject.setSubjectName("Data structures");
		Subject updateSubjectResponse;
		try {
			updateSubjectResponse = subjectservice.updateSubject("Data structures", subject);
			System.out.println("addSubjectResponse ::::: \n" + updateSubjectResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("All Subjects ::::::::: \n " + subjectservice.getAllSubjects());

	}

}

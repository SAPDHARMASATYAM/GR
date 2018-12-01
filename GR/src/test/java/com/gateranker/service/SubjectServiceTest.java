package com.gateranker.service;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gateranker.model.Subject;

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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Subject subject = new Subject();
		subject.setDatOfSubjectRegistration(new Date());
		subject.setSubjectActive(true);
		subject.setSubjectName("Data structures");
		subject.setNew(true);
		Subject addSubjectResponse = subjectservice.addSubject(subject);
		System.out.println("addSubjectResponse ::::: \n"+addSubjectResponse);
		System.out.println("All Subjects ::::::::: \n " + subjectservice.getAllSubjects());
		
	}

}

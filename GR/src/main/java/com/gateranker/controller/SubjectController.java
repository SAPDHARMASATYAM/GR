package com.gateranker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.jpa.model.Subject;
import com.gateranker.service.SubjectService;

@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/addSubject")
	public Subject register(@RequestBody Subject subject) throws Exception {
		return subjectService.addSubject(subject);
	}
	
	@GetMapping("/getAllSubjects")
	public List<Subject> getAllSubjects() throws Exception{
		return subjectService.getAllSubjects();
	}
}

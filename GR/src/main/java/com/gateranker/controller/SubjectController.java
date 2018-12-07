package com.gateranker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.jpa.model.Subject;
import com.gateranker.service.SubjectService;
/**
 * @author Sap Dharma Satyam
 */
@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@PostMapping("addSubject")
	public Subject addSubject(@RequestBody @Valid Subject subject) throws Exception {
		return subjectService.addSubject(subject);
	}

	@PutMapping("updateSubject/{subjectId}")
	public Subject updateSubject(@PathVariable(name = "subjectId", required = true) String subjectId,
			@RequestBody Subject subject) throws Exception {
		return subjectService.updateSubject(subjectId, subject);
	}

	@DeleteMapping("removeSubject/{subjectId}")
	public ResponseEntity<?> removeSubject(@PathVariable(name = "subjectId", required = true) String subjectId)
			throws Exception {
		return subjectService.removeSubject(subjectId);
	}

	@PutMapping("enableOrDisableSubject/{subjectId}/{activeIndicator}")
	public ResponseEntity<?> enableOrDisableSubject(@PathVariable(name = "subjectId", required = true) String subjectId,
			@PathVariable(name = "activeIndicator", required = true) boolean activeIndicator) throws Exception {
		Boolean enableOrDisableSubjectResponse = subjectService.enableOrDisableSubject(subjectId, activeIndicator);
		if (enableOrDisableSubjectResponse) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("getSubjectById/{subjectId}")
	public Subject getSubjectById(@PathVariable(name = "subjectId", required = true) String subjectId)
			throws Exception {
		return subjectService.getSubjectById(subjectId);
	}

	@GetMapping("getAllSubjects")
	public List<Subject> getAllSubjects() throws Exception {
		return subjectService.getAllSubjects();
	}

	@GetMapping("getAllSubjectsByActiveIndicator/{activeIndicator}")
	public List<Subject> getAllSubjectsByActiveIndicator(
			@PathVariable(name = "activeIndicator", required = true) boolean activeIndicator) throws Exception {
		return subjectService.getAllSubjectsByActiveIndicator(activeIndicator);
	}

}

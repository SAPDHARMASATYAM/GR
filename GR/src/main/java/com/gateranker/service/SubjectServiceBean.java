package com.gateranker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.repository.SubjectRepository;
import com.gateranker.model.Subject;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubjectServiceBean implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public Subject addSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}
	
}

package com.gateranker.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Subject;
import com.gateranker.jpa.repository.SubjectRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubjectServiceBean implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public Subject addSubject(Subject subject) throws Exception {
		Subject addSubjectResponse = null;
		
		try {
			addSubjectResponse = subjectRepository.save(subject);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Duplicate data : " + e.getMessage());
		}
		return 	addSubjectResponse;
		
	}

	@Override
	public List<Subject> getAllSubjects() throws Exception{
		return subjectRepository.findAll();
	}

	@Override
	public List<Subject> getAllActiveSubjects() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> getAllInActiveSubjects() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean enableOrDisableSubject(Subject subject, boolean flag) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

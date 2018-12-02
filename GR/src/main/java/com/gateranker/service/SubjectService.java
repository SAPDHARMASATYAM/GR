package com.gateranker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Subject;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface SubjectService {
	
	public Subject addSubject(Subject subject)throws Exception;
	public List<Subject> getAllSubjects()throws Exception;
	public List<Subject> getAllActiveSubjects()throws Exception;
	public List<Subject> getAllInActiveSubjects()throws Exception;
	public Boolean enableOrDisableSubject(Subject subject, boolean flag);
}

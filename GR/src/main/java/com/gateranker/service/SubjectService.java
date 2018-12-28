package com.gateranker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Subject;
/**
 * @author Sap Dharma Satyam
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface SubjectService {

	public Subject addSubject(Subject subject) throws Exception;

	public List<Subject> getAllSubjects() throws Exception;

	public Subject enableOrDisableSubject(String subject, boolean flag);

	public Subject updateSubject(String subjectId, Subject subject);

	public Boolean removeSubject(String subjectId);

	public Subject getSubjectById(String subjectId);

	public List<Subject> getAllSubjectsByActiveIndicator(boolean activeIndicator);
}

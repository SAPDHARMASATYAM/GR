package com.gateranker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.exception.ResourceNotFoundException;
import com.gateranker.jpa.model.Subject;
import com.gateranker.jpa.repository.SubjectRepository;
/**
 * @author Sap Dharma Satyam
 *
 */
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
		return addSubjectResponse;

	}

	@Override
	public List<Subject> getAllSubjects() throws Exception {
		return subjectRepository.findAll();
	}

	@Override
	public Boolean enableOrDisableSubject(String subjectId, boolean flag) {
		return subjectRepository.findById(subjectId).map(sub -> {
			sub.setIsSubjectActive(flag);
			Subject updateResponse = subjectRepository.save(sub);
			return (updateResponse != null) ? true : false;
		}).orElseThrow(() -> new ResourceNotFoundException("subjectId " + subjectId + " not found"));
	}

	@Override
	public Subject updateSubject(String subjectId, Subject subject) {
		return subjectRepository.findById(subjectId).map(sub -> {
			sub.setIsSubjectActive(subject.getIsSubjectActive());
			sub.setSubjectName(subject.getSubjectName());
			Subject updateResponse = subjectRepository.save(sub);
			return updateResponse;
		}).orElseThrow(() -> new ResourceNotFoundException("subjectId " + subjectId + " not found"));
	}

	@Override
	public ResponseEntity<?> removeSubject(String subjectId) {
		return subjectRepository.findById(subjectId).map(subject -> {
			subjectRepository.delete(subject);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("subject " + subjectId + " not found"));
	}

	@Override
	public Subject getSubjectById(String subjectId) {
		return subjectRepository.findById(subjectId).get();
	}

	@Override
	public List<Subject> getAllSubjectsByActiveIndicator(boolean activeIndicator) {
		return subjectRepository.findAllByIsSubjectActive(activeIndicator);
	}

}

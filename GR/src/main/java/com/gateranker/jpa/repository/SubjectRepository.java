package com.gateranker.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
	
}

package com.gateranker.jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateranker.jpa.model.UserSubject;

public interface UserSubjectRepository extends JpaRepository<UserSubject, UUID> {

	public Optional<UserSubject> findByUserAndSubject(String userName, String subjectName);

	public List<UserSubject> findAllByUser(String userName);

	public List<UserSubject> findAllByUserAndIsSubjectActiveForUser(String userName, Boolean activeIndicator);

}

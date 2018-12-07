/**
 * 
 */
package com.gateranker.jpa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.CourseSubject;

/**
 * @author Sap Dharma Satyam
 *
 */
@Repository
public interface CourseSubjectRepository extends JpaRepository<CourseSubject, UUID>{

	
}

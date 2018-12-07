/**
 * 
 */
package com.gateranker.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.jpa.model.Topic;

/**
 * @author Sap Dharma Satyam
 *
 */

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

	List<Topic> findAllBySubject(String subjectId);

	List<Topic> findAllBySubjectAndIsTopicActive(String subjectId, Boolean flag);

	List<Topic> findAllByIsTopicActive(Boolean flag);
}

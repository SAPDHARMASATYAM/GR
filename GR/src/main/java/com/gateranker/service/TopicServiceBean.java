/**
 * 
 */
package com.gateranker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.exception.ResourceNotFoundException;
import com.gateranker.jpa.model.Topic;
import com.gateranker.jpa.repository.TopicRepository;
/**
 * @author Sap Dharma Satyam
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TopicServiceBean implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gateranker.service.TopicService#addTopic(com.gateranker.jpa.model.Topic)
	 */
	@Override
	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gateranker.service.TopicService#getAllTopicsBySubject(com.gateranker.jpa.
	 * model.Subject)
	 */
	@Override
	public List<Topic> getAllTopicsBySubject(String subjectId) {
		return topicRepository.findAllBySubject(subjectId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gateranker.service.TopicService#getAllActiveTopicsBySubject(java.lang.
	 * String)
	 */
	@Override
	public List<Topic> getAllActiveTopicsBySubject(String subjectId) {
		return topicRepository.findAllBySubjectAndIsTopicActive(subjectId, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gateranker.service.TopicService#getAllInActiveTopicsBySubject(java.lang.
	 * String)
	 */
	@Override
	public List<Topic> getAllInActiveTopicsBySubject(String subjectId) {
		return topicRepository.findAllBySubjectAndIsTopicActive(subjectId, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gateranker.service.TopicService#getAllActiveTopics()
	 */
	@Override
	public List<Topic> getAllActiveTopics() {
		return topicRepository.findAllByIsTopicActive(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gateranker.service.TopicService#getAllInActiveTopics()
	 */
	@Override
	public List<Topic> getAllInActiveTopics() {
		return topicRepository.findAllByIsTopicActive(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gateranker.service.TopicService#getTopicById(java.lang.String)
	 */
	@Override
	public Optional<Topic> getTopicById(int topicId) {
		return topicRepository.findById(topicId);
	}

	@Override
	public ResponseEntity<?> enableOrDisableTopic(int topicId, boolean flag) {
		return topicRepository.findById(topicId).map(topic->{
			 topicRepository.save(null);
			 return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("topicId " + topicId + " not found"));
	}

	@Override
	public Topic updateTopic(int topicId, Topic topic) {
		
		return topicRepository.findById(topicId).map(t->{
			
			t.setIsTopicActive(topic.getIsTopicActive());
			t.setTopicName(topic.getTopicName());
			t.setSubject(topic.getSubject());
			t.setVideoUrl(topic.getVideoUrl());
			
			return topicRepository.save(t);
		}).orElseThrow(() -> new ResourceNotFoundException("topicId " + topicId + " not found"));
	}

}

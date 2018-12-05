package com.gateranker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Topic;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface TopicService {

	public Topic addTopic(Topic topic);

	public List<Topic> getAllTopicsBySubject(String subjectId);

	public List<Topic> getAllActiveTopicsBySubject(String subjectId);

	public List<Topic> getAllInActiveTopicsBySubject(String subjectId);

	public ResponseEntity<?> enableOrDisableTopic(int topicId, boolean flag);

	public List<Topic> getAllActiveTopics();

	public List<Topic> getAllInActiveTopics();

	public Optional<Topic> getTopicById(int topicId);

	public Topic updateTopic(int topicId, Topic topic);
}

package com.gateranker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gateranker.jpa.model.Subject;
import com.gateranker.jpa.model.Topic;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface TopicService {
	
	public Topic addTopic(Topic topic);
	public List<Topic> getAllTopicsBySubject(Subject subject);
	public List<Topic> getAllActiveTopicsBySubject(Subject subject);
	public List<Topic> getAllInActiveTopicsBySubject(Subject subject);
	public List<Topic> getTopicByTopicId(Topic topic);
	public Boolean enableOrDisableTopic(Topic topic);
}

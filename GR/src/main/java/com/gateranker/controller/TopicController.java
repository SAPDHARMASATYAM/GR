package com.gateranker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.jpa.exception.ResourceNotFoundException;
import com.gateranker.jpa.model.Topic;
import com.gateranker.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	@GetMapping("topic/{topicId}")
	public Topic getTopicById(@PathVariable(name = "topicId") String topicId) {
		return topicService.getTopicById(topicId);
	}

	@GetMapping("activeTopics")
	public List<Topic> getAllActiveTopics() {
		return topicService.getAllActiveTopics();
	}

	@GetMapping("inActiveTopics")
	public List<Topic> getAllInActiveTopics() {
		return topicService.getAllInActiveTopics();
	}

	@GetMapping("activeTopics/{subjectId}")
	public List<Topic> getAllActiveTopicsBySubject(@PathVariable(name = "subjectId") String subjectId) {
		return topicService.getAllActiveTopicsBySubject(subjectId);
	}

	@GetMapping("inActiveTopics{subjectId}")
	public List<Topic> getAllInActiveTopicsBySubject(@PathVariable(name = "subjectId") String subjectId) {
		return topicService.getAllInActiveTopicsBySubject(subjectId);
	}

	@PostMapping("topic")
	public Topic addTopic(@Valid @RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}

	@PutMapping("topic/{topicId}")
	public Topic updateTopic(@PathVariable(name = "topicId") int topicId, @Valid @RequestBody Topic topic) {
		return topicService.findById(topicId).map(t -> {

			t.setTopicName(topic.getTopicName());
			t.setVideoUrl(topic.getVideoUrl());
			return topicService.addTopic(t);

		}).orElseThrow(() -> new ResourceNotFoundException("topicId " + topicId + " not found"));
	}

}

package com.gateranker.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the topic database table.
 * 
 */
@Entity
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable , Persistable<Integer>{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="topic_id")
	private int topicId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_of_topic_registration")
	private Date dateOfTopicRegistration;

	@Column(name="is_topic_active")
	private boolean isTopicActive;

	@Column(name="topic_name")
	private String topicName;

	@Column(name="video_url")
	private String videoUrl;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subject_name")
	private Subject subject;

	@Transient
	@JsonIgnore
	private boolean  isNew = true;

	public Topic() {
	}

	
	public int getTopicId() {
		return topicId;
	}


	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}


	public Date getDateOfTopicRegistration() {
		return this.dateOfTopicRegistration;
	}

	public void setDateOfTopicRegistration(Date dateOfTopicRegistration) {
		this.dateOfTopicRegistration = dateOfTopicRegistration;
	}

	public boolean getIsTopicActive() {
		return this.isTopicActive;
	}

	public void setIsTopicActive(boolean isTopicActive) {
		this.isTopicActive = isTopicActive;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public Integer getId() {
		return null;
	}


	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", dateOfTopicRegistration=" + dateOfTopicRegistration + ", isTopicActive="
				+ isTopicActive + ", topicName=" + topicName + ", videoUrl=" + videoUrl + ", subject=" + subject
				+ ", isNew=" + isNew + "]";
	}

}
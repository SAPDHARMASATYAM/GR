package com.gateranker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="topic")
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable, Persistable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="topic_id", nullable=false, unique=true)
	private int topicId;
	
	@NotNull
	@Lob
	@Column(name="topic_name", unique=true)
	private String topicName;

	@NotNull
	@Lob
	@Column(name="topic_video_url", unique=true)
	private String topicVideoUrl;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "subject_name", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Subject subject;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_topic_registration", nullable = true)
	private Date datOfTopicRegistration;

	@Transient
	@JsonIgnore
	private boolean isNew = false;
	
	@Override
	public String getId() {
		return "";
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getDatOfTopicRegistration() {
		return datOfTopicRegistration;
	}

	public void setDatOfTopicRegistration(Date datOfTopicRegistration) {
		this.datOfTopicRegistration = datOfTopicRegistration;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getTopicVideoUrl() {
		return topicVideoUrl;
	}

	public void setTopicVideoUrl(String topicVideoUrl) {
		this.topicVideoUrl = topicVideoUrl;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", topicVideoUrl=" + topicVideoUrl
				+ ", subject=" + subject + ", datOfTopicRegistration=" + datOfTopicRegistration + ", isNew=" + isNew
				+ "]";
	}
	

}

package com.gateranker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="course_subject")
@NamedQuery(name="CourseSubject.findAll", query="SELECT cs FROM CourseSubject cs")
public class CourseSubject  implements Serializable, Persistable<CourseSubjectIdentity>  {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CourseSubjectIdentity courseSubjectIdentity;

	@Column(name="is_course_subject_active", nullable=false)
	private boolean isCourseSubjectActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_ccourse_subject_registration", nullable = true)
	private Date datOfCourseSubjectRegistration;
	
	@Transient
	@JsonIgnore
	private boolean isNew = false;
	
	public CourseSubjectIdentity getCourseSubjectIdentity() {
		return courseSubjectIdentity;
	}

	public void setCourseSubjectIdentity(CourseSubjectIdentity courseSubjectIdentity) {
		this.courseSubjectIdentity = courseSubjectIdentity;
	}

	public boolean isCourseSubjectActive() {
		return isCourseSubjectActive;
	}

	public void setCourseSubjectActive(boolean isCourseSubjectActive) {
		this.isCourseSubjectActive = isCourseSubjectActive;
	}

	public Date getDatOfCourseSubjectRegistration() {
		return datOfCourseSubjectRegistration;
	}

	public void setDatOfCourseSubjectRegistration(Date datOfCourseSubjectRegistration) {
		this.datOfCourseSubjectRegistration = datOfCourseSubjectRegistration;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public CourseSubjectIdentity getId() {
		return this.getCourseSubjectIdentity();
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	@Override
	public String toString() {
		return "CourseSubject [courseSubjectIdentity=" + courseSubjectIdentity + ", isCourseSubjectActive="
				+ isCourseSubjectActive + ", datOfCourseSubjectRegistration=" + datOfCourseSubjectRegistration
				+ ", isNew=" + isNew + "]";
	}
	
}

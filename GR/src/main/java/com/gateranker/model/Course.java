package com.gateranker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable, Persistable<String>  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="course_name", nullable=false, unique=true)
	private String courseName;

	@Column(name="is_course_active", nullable=false)
	private boolean isCourseActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_course_registration", nullable = true)
	private Date datOfCourseRegistration;
	
	@Transient
	@JsonIgnore
	private boolean isNew = false;
	
	public Course() {
	}

	@Override
	public String getId() {
		return this.getCourseName();
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	public Date getDatOfCourseRegistration() {
		return datOfCourseRegistration;
	}

	public void setDatOfCourseRegistration(Date datOfCourseRegistration) {
		this.datOfCourseRegistration = datOfCourseRegistration;
	}

	public boolean isCourseActive() {
		return isCourseActive;
	}

	public void setCourseActive(boolean isCourseActive) {
		this.isCourseActive = isCourseActive;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", isCourseActive=" + isCourseActive + ", datOfCourseRegistration="
				+ datOfCourseRegistration + ", isNew=" + isNew + "]";
	}

}
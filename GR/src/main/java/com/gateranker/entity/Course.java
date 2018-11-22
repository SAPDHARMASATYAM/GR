package com.gateranker.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.domain.Persistable;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable, Persistable<Integer>  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id", unique=true, nullable=false)
	private int courseId;

	
	@Column(name="course_name_in_english", nullable=false, unique=true)
	private String courseNameInEnglish;

	
	@Column(name="course_name_in_regional", nullable=false, unique=true)
	private String courseNameInRegional;

	@Column(name="is_course_active", nullable=false)
	private boolean isCourseActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_course_registration", nullable = false)
	private Date datOfCourseRegistration;
	
	@Transient
	private boolean isNew = false;
	
	public Course() {
	}

	@Override
	public Integer getId() {
		return this.getCourseId();
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseNameInEnglish() {
		return courseNameInEnglish;
	}

	public void setCourseNameInEnglish(String courseNameInEnglish) {
		this.courseNameInEnglish = courseNameInEnglish;
	}

	public String getCourseNameInRegional() {
		return courseNameInRegional;
	}

	public void setCourseNameInRegional(String courseNameInRegional) {
		this.courseNameInRegional = courseNameInRegional;
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

	public Date getDatOfCourseRegistration() {
		return datOfCourseRegistration;
	}

	public void setDatOfCourseRegistration(Date datOfCourseRegistration) {
		this.datOfCourseRegistration = datOfCourseRegistration;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseNameInEnglish=" + courseNameInEnglish
				+ ", courseNameInRegional=" + courseNameInRegional + ", isCourseActive=" + isCourseActive
				+ ", datOfCourseRegistration=" + datOfCourseRegistration + "]";
	}

}
package com.e_school.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "lectures")
public class Lectures {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "number")
	private int number;
	@NotNull
	@Column(name ="description")
	private String description;
	@NotNull
	@Column(name="file_pdf")
	private String url1;
	
	@OneToOne(mappedBy = "lecture_id", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<HomeworkTeacher> getHMT() {
		return HMT;
	}

	public void setHMT(Set<HomeworkTeacher> hMT) {
		HMT = hMT;
	}



	 @OneToMany(mappedBy = "lecture",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	 private Set<HomeworkTeacher> HMT = new HashSet<HomeworkTeacher>();
	
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="teacher_id")
	    private Teacher teacher;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="subject_id")
	    private Subject subject;
	
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="class_id")
	    private Class class_id;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Class getClass_id() {
		return class_id;
	}

	public void setClass_id(Class class_id) {
		this.class_id = class_id;
	}
	
	
	
	
}

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
import javax.persistence.Table;

import org.springframework.lang.NonNull;



@Entity
@Table(name="HomeworkTeacher")

public class HomeworkTeacher {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "file")
	private int url;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUrl() {
		return url;
	}

	public void setUrl(int url) {
		this.url = url;
	}


	

	
	 public Set<HomeworkStudent> getHMS() {
		return HMS;
	}

	public void setHMS(Set<HomeworkStudent> hMS) {
		HMS = hMS;
	}


	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="lecture_id")
	    private Lectures lecture;
	


	 @OneToMany(mappedBy = "HMT",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	 private  Set<HomeworkStudent> HMS = new HashSet<HomeworkStudent>();
	 
	 
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="teacher_id")
	    private Teacher teacher;
	
	
	 
	 
	 
	 
	
}

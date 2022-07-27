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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity
@Table(name="subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name ="name")
	private String name;
	
	@NotNull
	@Column(name ="description")
	private String description;
	
	@NotNull
	@Column(name ="hours")
	private String hours;
	
   @OneToMany(mappedBy = "subject",fetch =FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Lectures> lectures = new HashSet<Lectures>();
	   
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

  
	
	
	




	public Set<Lectures> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lectures> lectures) {
		this.lectures = lectures;
	}





 
	

	
	
}

package com.e_school.entity;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "grade")
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	int id;
	
	@Column(name = "level")
	@NotNull
	String level;
	
	@OneToMany(mappedBy = "grade_id",fetch = FetchType.EAGER,cascade = CascadeType.ALL )
	Set<Class> class_id =new TreeSet<Class>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set<Class> getClass_id() {
		return class_id;
	}

	public void setClass_id(Set<Class> class_id) {
		this.class_id = class_id;
	}
	
	
	

}

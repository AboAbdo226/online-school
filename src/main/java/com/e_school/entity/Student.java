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

import org.springframework.lang.NonNull;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name="fname")
	@NonNull
	private String fname;
	
	@Column(name="lname")
	@NonNull
	private String lname;


	 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	@OneToOne(fetch = FetchType.EAGER, optional = false,cascade = CascadeType.ALL)
	  @JoinColumn(name = "user_id", nullable = false ) 
	  private  User user_id;
      
	 
	

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}



	public Student(User user_id) {
		super();
		
		this.user_id = user_id;
	}
	public Student() {
	
	}


	@Column(name="document")
	private String url;
	
	


	public Set<HomeworkStudent> getHMS() {
		return HMS;
	}

	public void setHMS(Set<HomeworkStudent> hMS) {
		HMS = hMS;
	}

	
	
	 public Class getC() {
		return c;
	}

	public void setC(Class c) {
		this.c = c;
	}



	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="class_id")
	 private Class c;
	
   
	
	  @OneToMany(mappedBy = "student",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	  private Set<HomeworkStudent> HMS= new HashSet<HomeworkStudent>();
	
	 
	

}

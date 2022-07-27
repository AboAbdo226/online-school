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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name ="teacher")
public class Teacher {
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
	@Column(name="country")
	@NonNull
	private String country;
	
	public Teacher() {
		super();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}





	@Column(name="number")
	@NonNull
	private String number;
	


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

   
	



	

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Set<Lectures> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lectures> lectures) {
		this.lectures = lectures;
	}

	public Set<HomeworkTeacher> getHMT() {
		return HMT;
	}

	public void setHMT(Set<HomeworkTeacher> hMT) {
		HMT = hMT;
	}





	  public Teacher(User user_id) {
		super();
		this.user_id = user_id;
	}





	@OneToOne(fetch = FetchType.EAGER, optional = false,cascade = CascadeType.ALL)
	  @JoinColumn(name = "user_id", nullable = false ) 
	  private  User user_id;
	
	@OneToMany(mappedBy = "teacher",fetch =FetchType.EAGER,cascade = CascadeType.ALL)
	private  Set <Lectures> lectures = new HashSet<Lectures>();
	
	
	@OneToMany(mappedBy = "teacher",fetch =FetchType.EAGER,cascade = CascadeType.ALL)
	private Set <HomeworkTeacher> HMT =new HashSet<HomeworkTeacher>();
	

}

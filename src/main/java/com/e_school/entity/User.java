	package com.e_school.entity;
	
	

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.e_school.Repository.teacherAIO;


@Entity(name = "user")
@Table(name = "user")
public class User {
		
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name ="id")
	private long id ;
	@Column(name = "email",unique = true) 
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "isEnable")
	private boolean isEnable;
	@Column(name = "verifications")
	private String verifications;
	@Column(name = "BaneReason")
	private String banedReason;
	//private LocalDateTime time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getBanedReason() {
		return banedReason;
	}

	public void setBanedReason(String banedReason) {
		this.banedReason = banedReason;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnable() {
		return isEnable;
	}
	
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	public String getVerifications() {
		return verifications;
	}
	
	public void setVerifications(String verifications) {
		this.verifications = verifications;
	}
	
	
	
	@OneToOne(mappedBy = "user_id", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL , orphanRemoval = true)
	
     private Student student;
	
	  
	  
		@OneToOne(mappedBy = "user_id",fetch = FetchType.EAGER,
	     cascade = CascadeType.ALL )
		 private  Teacher teacher;
		
	 



	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		
		this.role = role;
	}


	  @OneToMany(mappedBy = "user",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	  private Set<Role> role = new HashSet<Role>();
	  
	  
	  
	  
	  
	  public void addRole(Role role) {
		  this.role.add(role);
		 
	  }
	
	  
	  public void RemoveRole(Role role) {
		  this.role.remove(role);
		  role.setUser(null);
	  }


	
	}


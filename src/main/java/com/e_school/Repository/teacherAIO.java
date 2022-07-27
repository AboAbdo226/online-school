package com.e_school.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;


public class teacherAIO {

	String email;
	boolean isEnable;
	String banedReason;
	String fname;
	String lname;
	List<String> subjectName;
	List<String> subject;
	int subjectId;
	public teacherAIO() {
		super();
	}
	public teacherAIO(String email, boolean isEnable, String banedReason, String fname, String lname) {
		super();
		this.email = email;
		this.isEnable = isEnable;
		this.banedReason = banedReason;
		this.fname = fname;
		this.lname = lname;
	}
	public teacherAIO(String email, boolean isEnable, String banedReason, String fname, String lname,
			List<String> subject) {
		super();
		this.email = email;
		this.isEnable = isEnable;
		this.banedReason = banedReason;
		this.fname = fname;
		this.lname = lname;
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	public String getBanedReason() {
		return banedReason;
	}
	public void setBanedReason(String banedReason) {
		this.banedReason = banedReason;
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
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
		//this.subject.add(subject);
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	@Override
	public String toString() {
		return "teacherAIO [subject=" + subject + "]";
	}
	public List<String> getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(List<String> subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
	

	
	
	
	
}

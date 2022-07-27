package com.e_school.entity;

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

import com.sun.istack.NotNull;

@Entity
@Table(name="HomeworkStudent")

public class HomeworkStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "Answer")
	private int url;
	
	@Column(name = "mark")
	private int mark;

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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="student_id")
	    private Student student;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="user_id")
	    private HomeworkTeacher HMT;
	
	
	
	
	
	

}

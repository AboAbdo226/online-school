package com.e_school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	String name;
	String type;
	long size;
	@Lob //// to tell them that this file is above 1mb size
	byte[] video;
	public Video( String name,long size,String type,  byte[] bs , Lectures l) {
		super();
		this.name = name;
		this.size = size;
		this.video = bs;
		this.type = type;
		this.lecture_id = l;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Video() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public byte[] getVideo() {
		return video;
	}
	public void setVideo(byte[] video) {
		this.video = video;
	}
	
	@OneToOne(fetch = FetchType.EAGER, optional = false,cascade = CascadeType.ALL)
	  @JoinColumn(name = "lecture_id", nullable = false ) 
	private Lectures lecture_id;
	
	public Lectures getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(Lectures lecture_id) {
		this.lecture_id = lecture_id;
	}
	public Video(Lectures lecture_id) {
		super();
		this.lecture_id = lecture_id;
	}
	
	
}

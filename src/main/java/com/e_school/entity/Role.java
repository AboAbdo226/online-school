package com.e_school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole_name() {
		return Role_name;
	}
	public void setRole_name(String role_name) {
		Role_name = role_name;
	}
	



	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "id")
	private  long id;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}




	public Role(String role_name, User user) {
		super();
		Role_name = role_name;
		this.user = user;
	}




	@Column(name = "role_name")
	private String Role_name;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn( name="user_id")
	    private User user;
	
	

}

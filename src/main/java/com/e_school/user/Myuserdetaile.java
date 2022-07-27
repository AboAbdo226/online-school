package com.e_school.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.e_school.Repository.RoleRepository;
import com.e_school.entity.Role;
import com.e_school.entity.User;



public class Myuserdetaile implements UserDetails {

	
	@Autowired
	RoleRepository repo;
	
	@Autowired
	User user;
	
	 
	public  Myuserdetaile (User user) {this.user =user;}
	
	public  Myuserdetaile () {
 
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Set<Role> roles = user.getRole();
//		List<SimpleGrantedAuthority> auth = new ArrayList<>();
//		for(Role role :roles) {
//			auth.add(new SimpleGrantedAuthority(role.getRole_name()));
//		}
//		return auth;
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();

	}


	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isEnable();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getEmail();
	}
	
	

}
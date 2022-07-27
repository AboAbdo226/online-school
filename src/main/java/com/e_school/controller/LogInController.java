package com.e_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.e_school.services.AuthenticationServices;

@Controller
public class LogInController {

	@Autowired 
	private AuthenticationServices authServ;
	
	@GetMapping("/login")
	public String login(Model model) {
//		User user=new User(); // spring do it automatically
//	    model.addAttribute("user",  user);
	  return "login.html";
	}
	

	
	@GetMapping("/dashboard")
	public String log(){
		
		return authServ.checkVerification();
	}
	
	

	
}

package com.e_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.e_school.entity.Student;
import com.e_school.entity.User;

@Controller
public class IndexController {



	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	@GetMapping("/a")
	public String hsome() {
		return "/admin/teacherEdite.html";
	}
	
	@GetMapping("/b")
	public String hsodme() {
		return "/admin/starterEditForm.html";
	}


	
	



}

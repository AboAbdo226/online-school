package com.e_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/profileSetting")
	public String profile()
	{
		return "/profile.html";
	}
}

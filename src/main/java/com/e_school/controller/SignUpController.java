package com.e_school.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.e_school.entity.Student;
import com.e_school.entity.Teacher;
import com.e_school.entity.User;
import com.e_school.services.AuthenticationServices;

@Controller
public class SignUpController {

	@Autowired 
	private AuthenticationServices authServ;
	@Autowired 
	private PasswordEncoder PasswordEncoder;
	
	
	@GetMapping("/signup")
	public String SU() {
		return "signup.html";}
	

	@GetMapping("/signUpStudent")
	public ModelAndView SUS(ModelAndView model) {
	//	Student student = new Student(user);   /// dont try plsssssss
	//	model.addObject("student", student);
		
		//User user=new User();  we can do it this way or let the spring do it magically
		 // model.addObject("user",  user);
		
		model.setViewName("/signupStudent.html");
		return model;
		}
	
	
	
	
	
	@RequestMapping(method =RequestMethod.POST ,value="/signUpStudent")
	 public String StudentVerifications(Student student , User user ,HttpServletRequest req) throws UnsupportedEncodingException, MessagingException {
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		
		/// i dont know how spring making new student or user
		 authServ.signingStudentUp(student,user,req);
		
		return "check.html" ;
	}
	

	@GetMapping("/signUpTeacher")  /// need work
	public String SUT(Model model) {
		User user=new User();

		  
		return "signupTeacher.html";
		}
	
	@RequestMapping(method =RequestMethod.POST ,value="/signUpTeacher")
	 public String TeacherVerifications(Teacher teacher , User user ,HttpServletRequest req) throws UnsupportedEncodingException, MessagingException {
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		
		/// i dont know how spring making new student or user
		 authServ.signingTeacherUp(teacher,user,req);

		return "check.html" ;
	}
	
 
	 @GetMapping("/verify")
	 public String verifyAccount(@Param("code") String code ,Model model) {
		 
		 boolean verify = authServ.verify(code);
		 String pageTitle =verify ? "Verifications Success!" : "Verifications 	Fiald!";
		 model.addAttribute("pageTitle", pageTitle);
		return ""+(verify ? "verifications_success" : "verifications_fiald");
	 }
	
}

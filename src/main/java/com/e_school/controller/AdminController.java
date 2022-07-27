package com.e_school.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.e_school.Repository.UserRepository;
import com.e_school.Repository.teacherAIO;
import com.e_school.entity.Lectures;
import com.e_school.entity.Subject;
import com.e_school.entity.Teacher;
import com.e_school.entity.User;
import com.e_school.services.SubjectService;
import com.e_school.services.UsersEditService;

@Controller
//@RequestMapping("/admin")
public class AdminController {

@Autowired
UserRepository UR;  // for test

@Autowired
UsersEditService UES;

@Autowired
SubjectService SS;

	@GetMapping("/adminDashboard")
	public String showAllStudent(Model model) {
		

		List<String> fofo = UR.fofo2();
//		System.out.println(fofo);
		model.addAttribute("users",fofo);
		return "/admin/show.html";
	}
	
	@GetMapping("/adminlogin") /// till i make rules and permitions 
	public String d(@ModelAttribute(value="ntf") String ntf, Model m ) {
		m.addAttribute("tf",ntf);
		return "/admin/admin-dashboard.html";
	}
	
	
	@PostMapping("/adminlogin/userDelete")
	public String userDelete(@RequestParam String userName,RedirectAttributes r)
	{
		if(!UES.delete(userName))
			r.addFlashAttribute("ntf", "some error accured , try again later ...");
		return "redirect:/adminlogin";	
	}
	
	
	@PostMapping("/adminlogin/teacherEdit")
	public String teacherEdit(@RequestParam String teacher , Model m ,RedirectAttributes r)
	{
		
//		User user = UR.findUserByemail(teacher);			
//		if(user.isEnable() == false && user.getBanedReason().equals("not_activated") ) {
//			teacherAIO t = UES.getTheStarterTeacher(teacher);
//			m.addAttribute("user",t);
//			return "/admin/teacherEdit.html";
//		}
//		teacherAIO t = UES.getTheExpertTeacher(teacher);
//		System.out.println(t.getSubject());
//		m.addAttribute("user",t);
//		return "/admin/teacherEdit.html";
		
		/*
		if(UES.getTheExpertTeacher(teacher) == null) {
		teacherAIO t = UES.getTheStarterTeacher(teacher);
		m.addAttribute("user",t);
		System.out.println(t.getLname() + " " + " nooooooooooooooooooobbb");
		return "/admin/teacherEdit.html";
	}
		teacherAIO t = UES.getTheExpertTeacher(teacher);
		System.out.println(t.getSubject()     + " " + " exxxxxxxxxxxxxxxxxxxx wooooooooo");
		m.addAttribute("user",t);
		*/	
		
		teacherAIO t = UES.getMutentTeacher(teacher);
		m.addAttribute("user",t);
		return "/admin/teacherEdit.html";
		
		
	}
	
	@PostMapping("/adminlogin/editDone")
	public String editDone(teacherAIO  user ,Model m)
	{
		User u = UR.findUserByemail(user.getEmail());
		Integer y = new Integer(user.getSubjectId());
//		 for(int i=0;i<user.getSubject().size();i++) // was for testing
//		 System.out.println(user.getSubject().get(i)+" " + i);
		System.out.println(user.getSubjectName().get(0));
		user.getSubjectName().set(0,user.getSubjectName().get(0).substring(1));
		user.getSubjectName().set(user.getSubjectName().size()-1 ,
				                  user.getSubjectName().get(0).substring(0,
				                		  user.getSubjectName().get(0).length()-1));
	
		
		if(!user.getSubject().contains(y.toString())) {
			user.getSubject().add(y.toString());
			user.getSubjectName().add(SS.findSubjectNameById(y));

		}
		
		//subjects = user.getSubject().split(" , "); // i used this way instead of list so i needed split and another array ... etc
		// for(int i=0;i<user.getSubject().size();i++) if i wanted to get them all 
		//{		
		
		
			int sub;
			sub =Integer.parseInt(user.getSubject().get(user.getSubject().size()-1));
			try {
			UES.checkTeacherSubject(user.getEmail(),sub);
			} catch (Exception e) {
				Subject subject = SS.findById(sub);
				Lectures l= new Lectures();
				l.setNumber(0);
				l.setDescription("المحاضرة التعريفية التثبيتية للاستاذ مبينة علاقته بتدريس المادة");
				Set<Lectures> setL = new HashSet<Lectures>();
				setL.add(l);
				subject.setLectures(setL);
				l.setTeacher(u.getTeacher());
				l.setSubject(subject);
				u.getTeacher().setLectures(setL);
			}

				u.getTeacher().setFname(user.getFname());
				u.getTeacher().setLname(user.getLname());
				u.setEnable(user.isEnable());
				u.setBanedReason(user.getBanedReason());
				//SS.saveNew(subject);
				UR.save(u);
				System.out.println("subject has secssesfully registerd for the user : " + user.getFname() +" "+user.getLname());
			
		//} for the for loop
				
		
		System.out.println(user.getBanedReason());
		System.out.print  (user.getEmail());
		System.out.println(user.getSubject());
		System.out.println(user.getFname());
		System.out.println(user.isEnable());
		

		System.out.println("saved");
		m.addAttribute("user",user);
		return "/admin/teacherEdit.html"; 
	}



}

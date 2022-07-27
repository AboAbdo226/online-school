package com.e_school.fetchController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.e_school.entity.Student;
import com.e_school.services.StudentFetchService;

@Controller
@RequestMapping("/studentSearch")
public class StudentFetchController {
	
	@Autowired
	StudentFetchService SS;
	
	@GetMapping("/")
	public String getTable()
	{
		return "/admin/studentTables.html";
	}
	
	@GetMapping("/all")
  public String getAllStudents(Model model,RedirectAttributes r)
  {
		List<Student> student = SS.getAllStudents();


		if( SS.error(student.size(),r))
			return "redirect:/adminlogin";
		
		model.addAttribute("students",student)
	     .addAttribute("number",student.size());
		
		return "/admin/studentTables.html";
  }
	
	@PostMapping("/ByName")
	  public String getStudentsByName(Model model,RedirectAttributes r,@RequestParam("name") String n)
	{
		List<Student> student = SS.getStudentsByName(n);
	
		if( SS.error(student.size(),r))
			return "redirect:/adminlogin";

		model.addAttribute("students",student)
			 .addAttribute("number",student.size());
		return "/admin/studentTables.html";
	}
	
	
	
	@PostMapping("/ById")
	  public String getStudentByID (Model model,RedirectAttributes r,@RequestParam("name") long id)
	{
		 boolean empty = SS.getStudentById(id).isEmpty();
		if(empty) {
			r.addFlashAttribute("ntf","لا يوجد أي نتيجة لبحثك");
			return "redirect:/adminlogin";}
		
		model.addAttribute("students",SS.getStudentById(id).get())
				.addAttribute("number",1);

		return "/admin/studentTables.html";
	}	
	
	
	
    	@PostMapping("/ByEmail")
	  public String getStudentByEmail (Model model,RedirectAttributes r,@RequestParam("name") String email)
	{
		 boolean empty = SS.getStudentByEmail(email).isEmpty();
		if(empty) {
			r.addFlashAttribute("ntf","لا يوجد أي نتيجة لبحثك");
			return "redirect:/adminlogin";}
		
		model.addAttribute("students",SS.getStudentByEmail(email).get())
		.addAttribute("number",1);
		return "/admin/studentTables.html";
	}
    
    	@PostMapping("/ByClass")
    	public String getStudentsByClass(Model m , RedirectAttributes RA , @RequestParam("name") int num )
    	{
    		List<Student> student = SS.getStudentsByClass(num);
    		SS.error(student.size(), RA);
    		m.addAttribute("students",student)
    		  .addAttribute("number",student.size());
    		return "/admin/studentTables.html";
    		
    	}
    	
    	@PostMapping("/ByGrade")
    	public String getStudentsByGrade(Model m , RedirectAttributes RA , @RequestParam("name") int num )
    	{
    		List<Student> student = SS.getStudentsByGrade(num);
    		SS.error(student.size(), RA);
    		m.addAttribute("students",student)
    		  .addAttribute("number",student.size());
    		return "/admin/studentTables.html";
    		
    	}

    	
    	@GetMapping("/bannedStudent")
    	public String getBannedStudent(Model m,RedirectAttributes RA)
    	{
    		List<Student> students = SS.findBannedStudents();
    		SS.error(students.size(), RA);
    		m.addAttribute("students",students)
    		  .addAttribute("number",students.size())
    		  .addAttribute("banned","محظور لك قرد");
    		return "/admin/studentTables.html";
    	}
	

}
 
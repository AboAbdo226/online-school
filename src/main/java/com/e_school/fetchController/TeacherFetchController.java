package com.e_school.fetchController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.e_school.entity.Teacher;
import com.e_school.services.TeacherFetchService;

@Controller
@RequestMapping("/teacherSearch")
public class TeacherFetchController {
	
	@Autowired
	TeacherFetchService TS;
	
	@GetMapping("/")
	public String getTable()
	{
		return "/admin/teacherTables.html";
	}
	
	@GetMapping("/all")
  public String getAllTeachers(Model model,RedirectAttributes r)
  {
		List<Teacher> teacher = TS.getAllTeachers();


		if( TS.error(teacher.size(),r))
			return "redirect:/adminlogin";
		
		model.addAttribute("teachers",teacher)
	     .addAttribute("number",teacher.size());
		
		return "/admin/teacherTables.html";
  }
	
	@PostMapping("/ByName")
	  public String getTeachersByName(Model model,RedirectAttributes r,@RequestParam("name") String n)
	{
		List<Teacher> teacher = TS.getTeachersByName(n);
	
		if( TS.error(teacher.size(),r))
			return "redirect:/adminlogin";

		model.addAttribute("teachers",teacher)
			 .addAttribute("number",teacher.size());
		return "/admin/teacherTables.html";
	}
	
	
	
	@PostMapping("/ById")
	  public String getTeacherByID (Model model,RedirectAttributes r,@RequestParam("name") long id)
	{
		 boolean empty = TS.getTeacherById(id).isEmpty();
		if(empty) {
			r.addFlashAttribute("ntf","لا يوجد أي نتيجة لبحثك");
			return "redirect:/adminlogin";}
		
		model.addAttribute("teachers",TS.getTeacherById(id).get())
				.addAttribute("number",1);

		return "/admin/teacherTables.html";
	}	
	
	
	
    	@PostMapping("/ByEmail")
	  public String getTeacherByEmail (Model model,RedirectAttributes r,@RequestParam("name") String email)
	{
		 boolean empty = TS.getTeacherByEmail(email).isEmpty();
		if(empty) {
			r.addFlashAttribute("ntf","لا يوجد أي نتيجة لبحثك");

			return "redirect:/adminlogin";}
		
		model.addAttribute("teachers",TS.getTeacherByEmail(email).get())
		.addAttribute("number",1);
		return "/admin/teacherTables.html";
	}
    
    	@PostMapping("/ByClass")
    	public String getTeachersByClass(Model m , RedirectAttributes RA , @RequestParam("name") int num )
    	{
    		List<Teacher> teacher = TS.getTeachersByClass(num);
    		if( TS.error(teacher.size(),RA))
    			return "redirect:/adminlogin";
    		m.addAttribute("teachers",teacher)
    		  .addAttribute("number",teacher.size());
    		return "/admin/teacherTables.html";
    		
    	}
    	
    	@PostMapping("/ByGrade")
    	public String getTeachersByGrade(Model m , RedirectAttributes RA , @RequestParam("name") int num )
    	{
    		List<Teacher> teacher = TS.getTeachersByGrade(num);
    		if( TS.error(teacher.size(),RA))
    			return "redirect:/adminlogin";
    		m.addAttribute("teachers",teacher)
    		  .addAttribute("number",teacher.size());
    		return "/admin/teacherTables.html";
    		
    	}
    	
    	@GetMapping("/bannedTeacher")
    	public String getBannedTeacher(Model m,RedirectAttributes RA)
    	{
    		List<Teacher> teachers = TS.getBannedTeachers();
    		if( TS.error(teachers.size(),RA))
    			return "redirect:/adminlogin";
    		m.addAttribute("teachers",teachers)
    		  .addAttribute("number",teachers.size())
    		  .addAttribute("banned","محظور لك قرد");
    		return "/admin/teacherTables.html";
    	}
	
    	
    	@GetMapping("/notActivated")
    	public String getNotActivatedTeachers(Model m , RedirectAttributes RA)
    	{
    	List<Teacher> teachers = TS.getNotActivatedTeachers();
    	if(TS.error(teachers.size(),RA))
    	{
    		return "redirect:/adminlogin";
    	}
    	
    	m.addAttribute("teachers",teachers)
    	.addAttribute("number",teachers.size());
    	return "/admin/teacherTables.html";	
    		
    	}
    	
    	
    	
    	
    	
}
 
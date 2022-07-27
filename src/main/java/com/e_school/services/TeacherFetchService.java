package com.e_school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.e_school.Repository.TeacherRepository;
import com.e_school.entity.Teacher;

@Service
public class TeacherFetchService {

	@Autowired
	TeacherRepository TR;

	public List<Teacher> getAllTeachers()
	{
		 List<Teacher> Teachers = TR.findAll();
		 return Teachers;
	}
	
	public int countNotRepeated()
	{
		 int Teachers = TR.number();
		 return Teachers;
	}
	
	public boolean error(int n, RedirectAttributes r)
	{
		if(n == 0) {
			r.addFlashAttribute("ntf","رو ولا , يلعن أبوك");
			return true;
		}
		return false;
	}

	public List<Teacher> getTeachersByName(String name)
	{
		List<Teacher> FBFN = TR.findByFname(name);
		return FBFN;
		
	}
	public Optional<Teacher> getTeacherById(long id)
	{
		Optional<Teacher> FBI = TR.findById(id); // ready from the jpa
		return FBI;
		
	}
	public Optional<Teacher> getTeacherByEmail(String email)
	{
		Optional<Teacher> FBE = TR.findByEmail(email);
		return FBE;
		
	}
	
	public List<Teacher> getTeachersByClass(int num)
	{
		List<Teacher> FBE = TR.findByClass(num);
		return FBE;
		
	}
	
	public List<Teacher> getTeachersByGrade(int num)
	{
		List<Teacher> FBE = TR.findByGrade(num);
		return FBE;
		
	}

	public List<Teacher> getBannedTeachers() {
		List<Teacher> Teachers = TR.findBannedTeachers("not_activated");
		return Teachers;
	}
	public List<Teacher> getNotActivatedTeachers() {
		List<Teacher> Teachers = TR.findNotActivatedTeachers("not_activated");
		return Teachers;
	}
}

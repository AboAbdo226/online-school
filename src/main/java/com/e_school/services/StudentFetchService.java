package com.e_school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.e_school.Repository.StudentRepository;
import com.e_school.entity.Student;

@Service
public class StudentFetchService {

	@Autowired
	StudentRepository SR;

	public List<Student> getAllStudents()
	{
		 List<Student> students = SR.findAll();
		 return students;
	}
	
	public int countNotRepeated()
	{
		 int students = SR.number();
		 return students;
	}
	
	public boolean error(int n,RedirectAttributes r)
	{
		if(n == 0) {
			r.addFlashAttribute("ntf","كتوب منيح ولا , يلعن أبوك");
			return true;
		}
		return false;
	}

	public List<Student> getStudentsByName(String name)
	{
		List<Student> FBFN = SR.findByFname(name);
		return FBFN;
		
	}
	public Optional<Student> getStudentById(long id)
	{
		Optional<Student> FBI = SR.findById(id); // ready from the jpa
		return FBI;
		
	}
	public Optional<Student> getStudentByEmail(String email)
	{
		Optional<Student> FBE = SR.findByEmail(email);
		return FBE;
		
	}
	
	public List<Student> getStudentsByClass(int num)
	{
		List<Student> FBE = SR.findByClass(num);
		return FBE;
		
	}
	
	public List<Student> getStudentsByGrade(int num)
	{
		List<Student> FBE = SR.findByGrade(num);
		return FBE;
		
	}

	public List<Student> findBannedStudents() {
		List<Student> students = SR.findBannedStudents("not_activated");
		return students;
	}

}

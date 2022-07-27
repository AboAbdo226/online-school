package com.e_school.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_school.Repository.SubjectRepository;
import com.e_school.Repository.TeacherRepository;
import com.e_school.Repository.UserRepository;
import com.e_school.Repository.teacherAIO;
import com.e_school.entity.Subject;

@Service
public class UsersEditService {

	@Autowired
	TeacherRepository TR;
	@Autowired
	UserRepository UR;
	@Autowired
	SubjectRepository SR;
	
	@Transactional
	public boolean delete(String email)
	{
		if(UR.deleteByEmail(email)<=0)
			return false;
		return true;
	}
	public teacherAIO getMutentTeacher(String email)
	{
		 teacherAIO teacher = UR.findMutentTeacher(email);
		 List<Integer> sub = SR.findTeachrSubjects(email);
		// List<String> string = sub.stream().map(Object::toString).collect(Collectors.toList());
		 List<String> stringI = new ArrayList<String>();
		 List<String> stringN = new ArrayList<String>();
		 for(int i=0;i<sub.size();i++)
		 { stringI.add(sub.get(i).toString());
		 String subjectN = SR.findSubjectById(sub.get(i));
		   stringN.add(subjectN);
		 System.out.println(stringI.get(i)+" " + i + " " + stringN.get(i));}
		 //teacher.getSubject().add(sub.get(i).toString());
			 teacher.setSubject(stringI);
			 teacher.setSubjectName(stringN);
		 return teacher;
	}

	
	public int checkTeacherSubject(String n, int i)
	{
		return UR.checkTeacherSubject(n, i);
	}
	
	
}
	
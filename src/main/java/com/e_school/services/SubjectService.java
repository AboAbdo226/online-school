package com.e_school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_school.Repository.SubjectRepository;
import com.e_school.entity.Subject;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository SR;
	
	public Subject saveNew(Subject l)
	{
		return SR.save(l);
	}
	public Subject findById(int id)
	{
		return SR.findById(id).get();
	}
	
	public String findSubjectNameById(int id)
	{
		return SR.findSubjectById(id);
	}
	
}

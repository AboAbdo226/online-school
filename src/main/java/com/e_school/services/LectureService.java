package com.e_school.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.e_school.Repository.LectureRepository;
import com.e_school.entity.Lectures;
import com.e_school.entity.Video;

@Service
public class LectureService {

	@Autowired
	LectureRepository LR;
	
	
	public Lectures saveLectureV(MultipartFile file , String name)
	{
		try {

			Lectures lectureV = new Lectures();
			lectureV.setVideo(new Video(name , file.getSize() , file.getContentType() ,file.getBytes(),lectureV));
			return LR.save(lectureV);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Optional<Lectures> getLecture(int id)
	{
		return LR.findById(id);
	}
	public List<Lectures> getAllLectures()
	{
		return LR.findAll();
	}

}

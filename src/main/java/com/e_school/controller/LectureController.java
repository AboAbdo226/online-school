package com.e_school.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.e_school.entity.Lectures;
import com.e_school.services.LectureService;

@Controller
public class LectureController {

	@Autowired
	LectureService LS; 
	@GetMapping("/lectures")
	public String showLectures(Model m)
	{
		List<Lectures> AL = LS.getAllLectures();
	
		m.addAttribute("lecture",AL);
		return "lectures";	
	}
	
	@GetMapping("/subjects")
	public String showsubjects(Model m)
	{
			return "/subjects.html";	
	}
	
	@PostMapping("/uploadLecture")
	public String upload(@RequestParam  MultipartFile[] video_lecture ,@RequestParam("name") String name)
	{
		
			for (MultipartFile MF : video_lecture) {
			
				LS.saveLectureV(MF,name);
		}
		
		return "redirect:/lectures";
	}
	
	@GetMapping("/downloadLecture/{videoId}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable("videoId") int id)
	{ 
		System.out.println(id + "\n\n\n\n");
		Lectures lectures =  LS.getLecture(id).get();  
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(lectures.getVideo().getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\"" + lectures.getVideo().getName() + "\"")
				.body(new ByteArrayResource(lectures.getVideo().getVideo()));
	}
	
	
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	  public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{


	           Lectures l = LS.getLecture(itemId).get();
	    response.setContentType("video/mp4");
	    response.getOutputStream().write(l.getVideo().getVideo());
	    response.getOutputStream().close();
	}

	

    

	
}

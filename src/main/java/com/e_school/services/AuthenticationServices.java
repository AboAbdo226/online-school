package com.e_school.services;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.e_school.Repository.UserRepository;
import com.e_school.entity.Student;
import com.e_school.entity.Teacher;
import com.e_school.entity.User;

import net.bytebuddy.utility.RandomString;

@Service
public class AuthenticationServices{
   
	@Autowired
	private UserRepository UR ;
	@Autowired
	private JavaMailSender MailSender ;
	

	
	
	public void save_user(User user) {
	
		String RandomCode = RandomString.make(64);
		user.setVerifications(RandomCode);
		UR.save(user);

	}
	
	public User findUser(String email) {
		 User user =UR.findUserByemail(email);
		 return user;
	}
	
	
	public boolean IsExists(String email) {
		
		if(UR.existsByemail(email))
			return true;
		return false;
		
	}

	public void SenderEmailVerification(User user ,String siteURL) throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		   String toAddress = user.getEmail();
		    String fromAddress = "www.ite328@gmail.com.com";
		    String senderName = "e-school Managment";
		    String subject = "Please verify your registration";
		    String content = "Dear ,<br>"
		            + "Please click the link below to verify your registration:<br>"
		            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
		            + "Thank you,<br>"
		            + "the E-school";
		     
		    MimeMessage message = MailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message);
		     
		    helper.setFrom(fromAddress, senderName);
		    helper.setTo(toAddress);
		    helper.setSubject(subject);
		     
		    content = content.replace("[[name]]", user.getEmail());
		    String verifyURL = siteURL + "/verify?code=" + user.getVerifications();
		    content = content.replace("[[URL]]", verifyURL);
		
		    helper.setText(content, true);
		    MailSender.send(message);
		
	}
	
	public boolean verify(String Verifications) {
		
		User user = UR.findUserByverifications(Verifications);
		if(user == null ||user.isEnable()) {return false;}
		else {
		  user.setEnable(true);
		  UR.save(user);
		  return true;
		}
	
	}
	
	// to check the user who is doing login if he a student or teacher for his dasboard
	public String checkVerification()
	{
		//getting the login user info
		Authentication a = SecurityContextHolder.getContext().getAuthentication(); 
		User user = UR.findUserByemail(a.getName());
	

		if(user.getStudent() == null)
		return"/teacher-dashboard.html";
		return "/student-dashboard.html";
	}
	
	
	////for the email service
	 public String getSiteURL(HttpServletRequest request) {

	        String siteURL = request.getRequestURL().toString();
	        System.out.println(request.getRequestURL() + "\n\n\n\n\n\n");
	        return siteURL.replace(request.getServletPath(), "");
	        
	    }

	public void signingStudentUp(Student student, User user, HttpServletRequest req) throws UnsupportedEncodingException, MessagingException {
		student.setUser_id(user);	
		user.setStudent(student);  
		user.setBanedReason("not_activated");
		save_user(user);
		SenderEmailVerification(user,getSiteURL(req));
		
	}

	public void signingTeacherUp(Teacher teacher, User user, HttpServletRequest req) throws UnsupportedEncodingException, MessagingException {

		teacher.setUser_id(user);	
		user.setTeacher(teacher);
		user.setBanedReason("not_activated");
		save_user(user);
		SenderEmailVerification(user, getSiteURL(req));
		
	}
	

}

package com.e_school.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class Security_Configuration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     
 		auth.userDetailsService(userDetailsService);
        		
	}
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        		.csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/","/register" , "/verification" ,"log","/assets/**",
	                		"/css/*","/css1/**", "/js/*" , "/img/*" ,
	                		"/fonts","/scss/*","/images/*","/icon/*","/vendor/*","/a","/b","/node_modules"
	                		,"/signup"
	                		,"/signUpStudent"
	                		,"/signUpTeacher"
	                		,"/loginCheck"
	                		
	                		
	                		
	                		//,"/uploadLecture"
	                		,"/studentSearch/**"
	                		,"/adminlogin/**"
	                		,"/teacherSearch/**"
	                		//,"/show"
	                		).permitAll() 
	                //.antMatchers("/verification-files").hasAnyRole("Admin")
	                .anyRequest().authenticated()	                
	                .and()
	     		   .formLogin().permitAll()
	     		   .loginPage("/login")
	     		   .defaultSuccessUrl("/dashboard")
	     		   .usernameParameter("email")
	     		   .and()
	     		   .logout().permitAll()
	                ;
}
	  
	  @Bean
	  public PasswordEncoder PasswordEncoder() {
		  return new BCryptPasswordEncoder();
	  }
}

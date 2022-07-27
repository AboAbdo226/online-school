package com.e_school;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.e_school.entity")
@EnableJpaRepositories("com.e_school.Repository")

@SpringBootApplication
//@ComponentScan("com.e_school.*")
public class Eschool_Application {
	
	public static void main(String[] args)  {
		SpringApplication.run(Eschool_Application.class, args);

	}

}

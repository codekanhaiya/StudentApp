package com.student.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.studentapp.services.UserService;

@SpringBootApplication
public class StudentappApplication implements CommandLineRunner{

	@Autowired
	private UserService userService; // Inject UserService to initialize default users

	@Override
	public void run(String... args) throws Exception { // Initialize default users on startup
		userService.initializeDefaultUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentappApplication.class, args);
	}

}

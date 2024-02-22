package com.nimap.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  this class is the main entry point for a Spring Boot application
@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		// SpringApplication.run() starts the Spring Boot application and sets up the application context
		SpringApplication.run(DemoApplication.class, args);
	}
}

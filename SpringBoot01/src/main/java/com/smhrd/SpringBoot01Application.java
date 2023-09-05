package com.smhrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot01Application {

	// Spring Boot 를 동작시키기 위한 main 메소드 
	// spring Boot 는 Tomcat 이 내장되어 있음 
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}

}

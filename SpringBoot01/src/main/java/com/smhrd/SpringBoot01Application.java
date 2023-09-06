package com.smhrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan 
//- 지정된 패키지 안에 있는 Class들을 스캔해서, Bean으로 등록
//- 자동으로, 이 파일 옆의 폴더들을 스캔
//- 우리가 패키지를 만들 때, 기본 패키지의 하위 패키지로 만들어야함
//@AutoConfiguration
//- 자동으로, Spring 프로젝트를 실행하기 위한 Bean들을 설정
//- application.properties에 기술된 내용을 바탕으로 설정 진행
//- auto configuration 라이브러리의 json파일에 기술되어 있는 내용대로, Bean에 대한 설정을 진행함
//이 두가지 어노테이션이 합쳐진게 @SpringBootApplication

@SpringBootApplication
public class SpringBoot01Application {

	// Spring Boot 를 동작시키기 위한 main 메소드 
	// spring Boot 는 Tomcat 이 내장되어 있음 
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}

}

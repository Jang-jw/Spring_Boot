package com.smhrd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity // 추가됨 : 이 DTO 를 Table 이라 지정하겠다 
@Data
public class Member {
	
	// JPA : NO SQL
	// ORM (Object Relational Mapping)
	// JAVA 객체 <--> DB Table
	// DTO 생성 == DB 에 Table 생성 
	// DTO 필드 => 컬럼 
	
	// 이메일
	@Id // primary key 를 지정하는 어노테이션 
	@Column(length = 100, updatable = false) // column 의 상세 특징을 정의 
	private String email;
	
	// 비밀번호 
	private String pw;
	
	// 전화번호 
	private String tel;
	
	// 집주소 
	private String address;

}

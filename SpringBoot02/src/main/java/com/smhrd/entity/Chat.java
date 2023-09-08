package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 
	private Long idx;
	
	private String email;
	
	private String message;
	
	// indate datetime default now() 
	@Column(columnDefinition = "datetime default now()", insertable = false, updatable = false)
	private Date indate;

}

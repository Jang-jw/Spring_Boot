package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Board {
	
	// idx int auto_increment, ... 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	private String title;
	
	@Column(updatable = false)
	private String writer;
	
	@Column(length = 1000)
	private String content;
	
	private String img;
	
	// indate datetime default now() 
	@Column(columnDefinition = "datetime default now()", insertable = false, updatable = false)
	private Date indate;
	
	// count int default 0 
	@Column(columnDefinition = "int dafault 0", insertable = false, updatable = false)
	private int count;

}

package com.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GoMainController {

	@RequestMapping("/")
	public String gomain() {
		
		return "main" ;
	}
}

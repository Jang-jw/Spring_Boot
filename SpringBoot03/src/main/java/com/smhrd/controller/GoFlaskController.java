package com.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GoFlaskController {

	@RequestMapping("/")
	public String main() {
		
		return "index" ;
	}

	@RequestMapping("/flask")
	public String flask() {
		
		return "Flask" ;
	}
}

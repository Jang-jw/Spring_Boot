package com.smhrd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Member;
import com.smhrd.repository.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository repo;
	
	// goMain 이라는 요청을 받으면 main.jsp
	@RequestMapping("/goMain")
	public String goMain() {
		
		return "main";
	}
	
	@RequestMapping("/join")
	public String join(Member member) {
		
		// 1. 수집 
		
		
		// 2. 기능 정의 및 실행 
		repo.save(member);
		
		// 3. View 선택 
		return "redirect:/goMain";
	}
	
	@RequestMapping("/login")
	public String login(Member member, Model model, HttpSession session) {
		
		repo.findByEmailAndPw(member.getEmail(), member.getPw());
		
		model.addAttribute(member);
		session.setAttribute("user", member);
		
		return "join_success";
	}

}

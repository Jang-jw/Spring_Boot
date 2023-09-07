package com.smhrd.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String login(String email, String pw, HttpSession session) {

		Member member = repo.findByEmailAndPw(email, pw);

		if (member != null) {
			session.setAttribute("user", member);
		}

		return "redirect:/goMain";
	}
	
	@RequestMapping("/goUpdate")
	public String goUpdate() {
		
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(Member member, HttpSession session) {
		
		Member result = repo.save(member);
		
		session.setAttribute("user", result);
		
		return "redirect:/goMain";
	}

}

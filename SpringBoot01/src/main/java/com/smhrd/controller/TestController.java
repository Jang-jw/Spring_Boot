package com.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/ex01")
	public String ex01(Model model, HttpSession session) {

		model.addAttribute("name", "김준우");

		ArrayList<String> list = new ArrayList<String>();
		list.add("이우석");
		list.add("김준연");
		list.add("김유성");
		list.add("장재욱");
		model.addAttribute("list", list);

		session.setAttribute("data", "세션에 저장된 값");

		return "Ex01"; // templates/Ex01.hmtl
	}
}
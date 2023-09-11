package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Board;
import com.smhrd.repository.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardRepository repo;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<Board> list = repo.findAll();
		
		model.addAttribute("list", list);
		
		return "boardMain";
	}
	
	@GetMapping("/write") // get 방식으로 요청했을 때 
	public String goWrite() {
		
		return "writerBoard";
	}
	
	@PostMapping("/write") // post 방식으로 요청했을 때 
	public String write(Board board) {
		
		repo.save(board);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/flask")
	public String flask() {
		
		return "Flask";
	}

}

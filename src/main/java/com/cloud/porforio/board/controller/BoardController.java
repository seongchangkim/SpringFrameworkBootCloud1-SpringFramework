package com.cloud.porforio.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.board.service.BoardService;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.User;

@Controller
@RequestMapping("/cloud/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Board> list = service.list();
		model.addAttribute("list",list);
		return "/board/list";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String id = auth.getName();
		String name = service.selectName(id);
		User user = new User(id,name);
		model.addAttribute("user",user);
		return "/board/add";
	}
}

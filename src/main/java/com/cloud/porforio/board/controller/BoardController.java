package com.cloud.porforio.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.board.service.BoardService;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cloud/board")
@Log4j
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Board> list = service.list();
		model.addAttribute("list",list);
		return "/board/list";
	}
	
	@GetMapping(value="/add")
	public String addForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String id = auth.getName();
		String name = service.selectName(id);
		User user = new User(id,name);
		model.addAttribute("user",user);
		return "/board/add";
	}
	
	
	@PostMapping(value="/add")
	public String add(@ModelAttribute Board board, MultipartHttpServletRequest multipartHttpServlet) throws Exception {
		service.add(board, multipartHttpServlet);
		
		return "redirect:/cloud/board/list";
	}
	
}

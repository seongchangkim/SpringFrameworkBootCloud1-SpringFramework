package com.cloud.porforio.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.board.service.BoardService;
import com.cloud.porforio.domain.Board;

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
	
}

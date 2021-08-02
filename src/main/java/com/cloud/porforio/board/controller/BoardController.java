package com.cloud.porforio.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.porforio.board.service.BoardService;
import com.cloud.porforio.commons.util.FileUtils;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.User;

@Controller
@RequestMapping("/cloud/board")
public class BoardController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
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
	public String add(@ModelAttribute Board board, MultipartHttpServletRequest multipartHttpServlet, HttpServletRequest request) throws Exception {
		service.add(board, multipartHttpServlet, request);
		
		return "redirect:/cloud/board/list";
	}
	
	@GetMapping(value="/openBoard")
	public String openBoard(int bno, Model model) {
		service.updateReadCount(bno);
		Board board = service.selectBoard(bno);
		BoardFile file = service.selectBoardFile(bno);
		
		model.addAttribute("board",board);
		model.addAttribute("file",file);
		return "/board/boardDetail";
	}
	
	@PostMapping(value="/updateBoard")
	public String updateBoard(Board board) {
		boolean isUpdateBoard = service.updateBoard(board);
		
		return "redirect:/cloud/board/list";
	}
	
	@PostMapping(value="/deleteBoard")
	public String deleteBoard(Board board) {
		boolean isDeleteBoard = service.deleteBoard(board.getBno());
		
		return "redirect:/cloud/board/list";
	}
	
	//파일 다운로드
	@GetMapping(value="/downloadFile")
	public ModelAndView downloadFile(int bno, HttpServletRequest request){
		BoardFile file = service.selectBoardFile(bno);
		
		String filePath = file.getStoredFileName();
		
		File downFile = new File(file.getOriginalFileName());
		File downloadFile = new File(filePath + file.getOriginalFileName());
			
		return new ModelAndView("/cloud/board/openBoard?bno="+bno, "downloadFile", downloadFile);
		
	}
}

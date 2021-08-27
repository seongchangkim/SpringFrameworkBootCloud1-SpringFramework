package com.cloud.porforio.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.Criteria;
import com.cloud.porforio.domain.PageMaker;
import com.cloud.porforio.domain.Reply;
import com.cloud.porforio.domain.User;
import com.cloud.porforio.service.BoardService;

@Controller
@RequestMapping("/cloud/board/*")
public class BoardController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService service;
	
	@GetMapping(value="/list")
	public String list(@ModelAttribute("cri") Criteria cri,Model model) {
		
		List<Board> list = service.list(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
//		log.warn(""+(cri.getType() == "T".toString()));
		pageMaker.setTotalCount(service.getTotal(cri));
//		log.warn(""+service.getTotal(cri));
//		log.warn(""+list.size());
		pageMaker.calcData();
		
		model.addAttribute("list",list);
		model.addAttribute("pageMaker",pageMaker);
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
	public String add(@ModelAttribute Board board, @Nullable MultipartHttpServletRequest multipartHttpServlet, HttpServletRequest request) throws Exception {
		log.warn(request.getParameter("files"));
		service.add(board, multipartHttpServlet, request);
		
		return "redirect:/cloud/board/list";
	}
	
	@GetMapping(value="/openBoard")
	public String openBoard(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		service.updateReadCount(bno);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String id = auth.getName();
		String name = service.selectName(id);
		Board board = service.selectBoard(bno);
		ArrayList<BoardFile> file = service.selectBoardFileList(bno);
		ArrayList<Reply> replyList = service.selectReplyList(bno);
		model.addAttribute("userId",id);
		model.addAttribute("board",board);
		model.addAttribute("file",file);
		model.addAttribute("cri",cri);
		model.addAttribute("replyList",replyList);
		model.addAttribute("username",name);
		return "/board/boardDetail";
	}
	
	@PostMapping(value="/updateBoard")
	public String updateBoard(Board board, @ModelAttribute("cri") Criteria cri) {
		boolean isUpdateBoard = service.updateBoard(board);
		
		return "redirect:/cloud/board/list" + cri.getListLink();
	}
	
	@PostMapping(value="/deleteBoard")
	public String deleteBoard(Board board, @ModelAttribute("cri") Criteria cri) {
		boolean isDeleteBoard = service.deleteBoard(board.getBno());
		
		return "redirect:/cloud/board/list" + cri.getListLink();
	}
	
	//파일 다운로드(2021.08.02)
	@GetMapping(value="/downloadFile")
	public ModelAndView downloadFile(int idx, HttpServletRequest request){
		BoardFile file = service.selectBoardFile(idx);
		
		String filePath = file.getStoredFilePath();
		File downloadFile = new File(filePath);
			
		log.info(filePath);
		return new ModelAndView("fileDownloadView", "downloadFile", downloadFile);
		
	}
}

package com.cloud.porforio.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.board.service.ReplyService;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.Criteria;
import com.cloud.porforio.domain.Reply;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cloud/reply/*")
@Log4j
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	@PostMapping(value="/add")
	public String add(Reply reply, Model model, Criteria cri) {
		service.add(reply);
		Board board = service.selectBoard(reply.getBno());
		BoardFile file = service.selectBoardFile(reply.getBno());
		ArrayList<Reply> replyList = service.selectReplyList(reply.getBno());
		model.addAttribute("board",board);
		model.addAttribute("file",file);
		model.addAttribute("cri",cri);
		model.addAttribute("replyList",replyList);
		return "/board/boardDetail";
	}
	
	@PostMapping(value="/updateReply")
	public String updateReply(@ModelAttribute("reply") Reply reply, @ModelAttribute("cri") Criteria cri, Model model) {
		boolean isUpdateReply = service.updateReply(reply);
		Board board = service.selectBoard(reply.getBno());
		BoardFile file = service.selectBoardFile(reply.getBno());
		ArrayList<Reply> replyList = service.selectReplyList(reply.getBno());
		model.addAttribute("board",board);
		model.addAttribute("file",file);
		model.addAttribute("cri",cri);
		model.addAttribute("replyList",replyList);
		return "/board/boardDetail"; 
	}
	
	@PostMapping(value="/deleteReply")
	public String deleteReply(@ModelAttribute("reply") Reply reply, @ModelAttribute("cri") Criteria cri, Model model) {
		boolean isdeleteReply = service.deleteReply(reply.getRno());
		Board board = service.selectBoard(reply.getBno());
		BoardFile file = service.selectBoardFile(reply.getBno());
		ArrayList<Reply> replyList = service.selectReplyList(reply.getBno());
		model.addAttribute("board",board);
		model.addAttribute("file",file);
		model.addAttribute("cri",cri);
		model.addAttribute("replyList",replyList);
		return "/board/boardDetail";
	}
}

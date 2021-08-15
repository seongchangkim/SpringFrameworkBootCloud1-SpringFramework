package com.cloud.porforio.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.board.service.ReplyService;
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
	public String add(Reply reply, Model model) {
		service.add(reply);
		service.upUpdateReplyCount(reply.getBno());
		
		return "redirect:/cloud/board/openBoard?bno=" + reply.getBno();
	}
	
	@PostMapping(value="/updateReply")
	public String updateReply(@ModelAttribute Reply reply, @ModelAttribute("cri") Criteria cri, Model model) {
		boolean isUpdateReply = service.updateReply(reply);
		
		return "redirect:/cloud/board/openBoard?bno=" + reply.getBno(); 
	}
	
	@GetMapping(value="/deleteReply")
	public String deleteReply(int rno, Model model) {
		int bno = service.selectBno(rno);
		
		boolean isdeleteReply = service.deleteReply(rno);
		
		if(isdeleteReply) {
			service.downUpdateReplyCount(rno);
		}
	
		return "redirect:/cloud/board/openBoard?bno=" + bno;
	}
}	

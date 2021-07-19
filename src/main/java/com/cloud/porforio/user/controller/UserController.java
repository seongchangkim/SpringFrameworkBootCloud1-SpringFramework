package com.cloud.porforio.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/cloud")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/login")
	public String login(String logout, HttpSession session) {
		
		if(logout != null) {
			session.invalidate();
		}
		
		return "/user/login";
	}
	
	/*
	@PostMapping(value="/login")
	public void loginProcess(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
		User user = service.getUserInfo(id,password);
		
		model.addAttribute("user",user);
	}
	*/
	
	@GetMapping(value="/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping(value="/register")
	public String register(User user) {
		log.info(user);
		service.registerAuth(user.getId());
		service.register(user);
		
		return "redirect:/user/login";
	}
}

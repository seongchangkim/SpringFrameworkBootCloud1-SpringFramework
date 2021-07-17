package com.cloud.porforio.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.service.UserService;

@Controller
public class UserController {
	
	private UserService service;
	
	@GetMapping(value = "/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping(value="/register")
	public String register(User user) {
		String 
		service.register(user);
		return "redirect:/user/login";
	}
}

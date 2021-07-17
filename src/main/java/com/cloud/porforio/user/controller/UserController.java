package com.cloud.porforio.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping(value="/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping(value="/register")
	public String register(User user) {
		log.info(user);
		service.register(user);
		return "redirect:/user/login";
	}
}

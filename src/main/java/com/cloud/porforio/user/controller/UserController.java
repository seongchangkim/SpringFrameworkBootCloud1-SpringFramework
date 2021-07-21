package com.cloud.porforio.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cloud")
@Log4j
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/login")
	public String login(){
		return "login";
	}
	
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
	
	@GetMapping(value="/findingId")
	public String findingId() {
		return "/user/findingIdForm";
	}
	
	@PostMapping(value="/findingId")
	public String findingIdProcess(Model model, String email, String tel, String name) {
		User user = service.findingId(email, tel, name);
		model.addAttribute("user",user);
		
		return "/user/findingIdProcess";
	}
	
	@GetMapping(value="/findingPassword")
	public String findingPassword() {
		return "/user/findingPasswordForm";
	}
	
	@PostMapping(value="/findingPassword")
	public String findingPasswordProcess(String email, String tel, String name, String id, Model model) {
		String password = service.findingPassword(email, tel, name, id);
		model.addAttribute("v_password",password);
		model.addAttribute("id",id);
		return "/user/updatePassword";
	}
	
	@GetMapping(value="/updatePassword")
	public String updatePasswordForm() {
		return "/user/updatePassword";
	}
	
	@PostMapping(value="/updatePassword")
	public String updatePassword(String id, String password) {
		boolean isUpdatePassword = service.isUpdatePassword(id, password);
		
		log.info(isUpdatePassword);
		
		if(isUpdatePassword) {
			
		}
		
		return "/user/updatedPassword";
	}
}

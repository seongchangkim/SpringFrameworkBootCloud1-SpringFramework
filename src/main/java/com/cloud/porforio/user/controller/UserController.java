package com.cloud.porforio.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.user.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/cloud")
public class UserController {
	
	@Autowired
	private UserService service;
	
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
		service.registerAuth(user.getId());
		service.register(user);
		
		return "redirect:/user/login";
	}
	
	@GetMapping(value="findingId")
	public String findingId() {
		return "/user/findingIdForm";
	}
	
	@PostMapping(value="findingId")
	public String findingIdProcess(Model model, String email, String tel, String name) {
		User user = service.findingId(email, tel, name);
		model.addAttribute("user",user);
		
		return "/user/findingIdProcess";
	}
	
	@GetMapping(value="findingPassword")
	public String findingPassword() {
		return "/user/findingPasswordForm";
	}
	
	@PostMapping(value="findingPassword")
	public String findingPasswordProcess(String email, String tel, String name, String inputId, HttpServletRequest req) {
		String id = service.findingPassword(email, tel, name, inputId);
		req.setAttribute("id",id);
		
		return "/user/updatePassword";
	}
	
	@PostMapping(value="updatedPassword")
	public String updatePassword(String password, String id, Model model) {
		boolean isUpdatePassword = service.isUpdatePassword(password, id);
		String name = service.selectUserName(id, password);
		
		if(isUpdatePassword) {
			model.addAttribute("username", name);
			return "/user/updatedPassword";
		}else {
			return "redircet:/user/updatePassword";
		}
	}
}

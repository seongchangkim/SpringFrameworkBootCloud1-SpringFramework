package com.cloud.porforio.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.security.CustomBcryptPasswordEncoder;
import com.cloud.porforio.user.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cloud")
@Log4j
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
		
		return "redirect:/cloud/login";
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
		String password = service.findingPassword(email, tel, name);
		if(password == null) {
			return "/user/updatePassword";
		}else {
			model.addAttribute("v_password",password);
			model.addAttribute("id",id);
			return "/user/findingPasswordForm";
		}
	}

	@GetMapping(value="/updatePassword")
	public String updatePasswordForm() {
		return "/user/updatePassword";
	}

	@PostMapping(value="/updatePassword")
	public String updatePassword(String id, String password, Model model) {
		
		boolean isUpdatePassword = service.isUpdatePassword(id, password);
		String name = service.selectName(id);
		log.info(isUpdatePassword);
		
		if(isUpdatePassword) {
			model.addAttribute("name",name);
		}
		
		return "/user/complateUpdatePassword";
	}
	
	@GetMapping(value="/updateUserInfoPasswordVerity")
	public String updateUserInfoPasswordVerityForm() {
		return "/user/updateUserInfoPasswordVerityForm";
	}
	
	@PostMapping(value="/updateUserInfoPasswordVerity")
	public String updateUserInfoPasswordVerity(String id, String password) {
		String pass = service.selectPassword(id);
		CustomBcryptPasswordEncoder auth = new CustomBcryptPasswordEncoder();
		boolean isAuth = auth.matches(passwordEncoder.encode(password),pass);
		System.out.println(isAuth);
		if(!isAuth) {
			return "/user/updateUserInfoPasswordVerityForm";
		}else {
			return "/user/updateUserInfoForm";
		}
	}
	
	@PostMapping(value="/updateUserInfo")
	public String updateUserInfo(String id, String email, String name, String tel) {
		return "/main";
	}
}

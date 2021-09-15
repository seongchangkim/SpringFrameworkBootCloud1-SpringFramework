package com.cloud.porforio.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.security.CustomPasswordEncoder;
import com.cloud.porforio.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cloud")
@Log4j
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private CustomPasswordEncoder passwordEncoder;
	
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
		service.register(user);
		service.registerAuth(user.getId());
		
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
		String password = service.findingPassword(email, tel, name, id);
		
		if(password != null) {
			model.addAttribute("password",password);
			model.addAttribute("id",id);
			return "/user/updatePassword";
		}else {
			return "/user/findingPasswordForm";
		}
	}

	@GetMapping(value="/updatePassword")
	public String updatePasswordForm() {
		return "/user/updatePassword";
	}

	@PostMapping(value="/updatePassword")
	public String updatePassword(@RequestParam("id") String id, @RequestParam("password") String password, Model model, String v_pw) {
		String e_password = passwordEncoder.encode(password);
		if(!passwordEncoder.matches(password,v_pw)) {
			boolean isUpdatePassword = service.isUpdatePassword(id, e_password);
			String name = service.selectName(id);
			
			if(isUpdatePassword) {
				model.addAttribute("name",name);
			}
			
			return "/user/complateUpdatePassword";
		}else {
			return "/user/updatePassword";
		}
	}
	
	
	@GetMapping(value="/user/updateUserInfoPasswordVerify")
	public String updateUserInfoPrivacyForm() {
		return "/user/updateUserInfoPasswordVerifyForm";
	}
	
	@PostMapping(value="/user/updateUserInfoPasswordVerify")
	public String updateUserInfoPrivacyForm(String id, String password, Model model) {
		String v_password = service.selectPassword(id);
		if(passwordEncoder.matches(password, v_password)) {
			User user = service.selectUserInfo(id);
			model.addAttribute("user",user);
			return "/user/updateUserInfoForm";
		}else {
			return "/user/updateUserInfoPasswordVerifyForm"; 
		}
	}
	
	@PostMapping(value="/user/updateUserInfo")
	public String updateUserInfo(User user, Model model) {
		boolean isUpdateUserInfo = service.updateUserInfo(user);
		
		if(isUpdateUserInfo) {
			return "redirect:/cloud/user/profile?id="+user.getId();
		}else {
			return "/user/updateUserInfoForm";
		}
	}
	
	@GetMapping(value="/user/deleteUserInfoPasswordVerify")
	public String deleteUserInfoPasswordVerifyForm() {
		return "/user/deleteUserInfoPasswordVerifyForm";
	}
	
	@PostMapping(value="/user/deleteUserInfoPasswordVerify")
	public String deleteUserInfoPasswordVerify(String id, String password, HttpSession session) {
		String v_password = service.selectPassword(id);
		boolean deleteUserInfo = service.deleteUserInfo(id);
		boolean deleteUserAuth = service.deleteUserAuth(id);
		
		if(passwordEncoder.matches(password,v_password)) {
			if(deleteUserInfo) {
				session.invalidate();
				return "redirect:/cloud/login";
			}else {
				return "/user/deleteUserInfoPasswordVerifyForm";
			}
			
		}else {
			return "/user/deleteUserInfoPasswordVerifyForm";
		}
	}
	
	@GetMapping("/user/profile")
	public String profile(String id, Model model) {
		User user = service.selectUserInfo(id);
		model.addAttribute("user",user);
		return "/user/profile";
	}
	
}

package com.cloud.porforio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.porforio.domain.User;
import com.cloud.porforio.security.CustomPasswordEncoder;
import com.cloud.porforio.service.AdminService;

@Controller
@RequestMapping("/cloud/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@Autowired
	private CustomPasswordEncoder encoder;
	
	@GetMapping(value = "/userList")
	public String userList(Model model) {
		List<User> list = service.getUserList();
		model.addAttribute("list",list);
	
		return "/admin/userList";
	}
	
	@GetMapping(value = "/selectUserInfoDetail")
	public String selectUserInfoDetail(String id, Model model) {
		User user = service.selectUserInfoDetail(id);
		model.addAttribute("user",user);
		
		return "/admin/userInfoDetail";
	}
	
	@PostMapping(value="/updateUserInfo")
	public String updateUserInfo(User user, Model model) {
		boolean isUpdateUserInfo = service.updateUserInfo(user);
		
		if(isUpdateUserInfo) {
			List<User> list = service.getUserList();
			model.addAttribute("list",list);
			return "/admin/userList";
		}else {
			return "/admin/userInfoDetail";
		}
	}
	
	@GetMapping(value="deleteUserInfo")
	public String deleteUserInfo(String id, Model model) {
		boolean isDeleteUserInfo = service.deleteUserInfo(id);
		List<User> list = service.getUserList();
		model.addAttribute("list",list);	
		return "/admin/userList";
	}
	
	@GetMapping(value = "profile")
	public String profile(String id, Model model) {
		User user = service.selectUserInfoDetail(id);
		model.addAttribute("user",user);
		return "/user/profile";
	}
	
	@GetMapping(value = "updateUserInfoPasswordVerify")
	public String updateUserInfoPasswordVerifyForm() {
		return "/admin/adminUpdateUserInfoPasswordVerifyForm";
	}
	
	@PostMapping(value = "updateUserInfoPasswordVerify")
	public String updateUserInfoPasswordVerify(String id, String password, Model model) {
		String v_password = service.selectUserPassword(id);
		if(encoder.matches(password,v_password)) {
			User user = service.selectUserInfoDetail(id);
			model.addAttribute("user",user);
			return "/admin/adminUpdateUserInfoForm";
		}else {
			return "/admin/adminUpdateUserInfoPasswordVerifyForm";
		}
	}
	
	@PostMapping(value = "updateUserInfoYourself")
	public String updateUserInfo(User user) {
		boolean isUpdateUserInfo = service.updateUserInfo(user);
		
		if(isUpdateUserInfo) {
			return "/admin/adminProfile";
		}else {
			return "/admin/adminUpdateUserInfoPasswordVerifyForm";
		}
	}
	
	@GetMapping(value = "deleteUserInfoPasswordVerify")
	public String deleteUserInfoPasswordVerifyForm() {
		return "/admin/adminDeleteUserInfoPasswordVerifyForm";
	}
	
	@PostMapping(value = "deleteUserInfoPasswordVerify")
	public String deleteUserInfoYourSelf(String id, String password,HttpSession session) {
		String v_password = service.selectUserPassword(id);
		
		if(encoder.matches(password,v_password)) {
			boolean isdeleteUserInfo = service.deleteUserInfo(id);
			if(isdeleteUserInfo) {
				session.invalidate();
				return "redirect:/cloud/login";
			}else {
				return "/admin/adminDeleteUserInfoPasswordVerifyForm";
			}
		}else {
			return "/admin/adminDeleteUserInfoPasswordVerifyForm";
		}
			
	}
}

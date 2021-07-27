package com.cloud.porforio;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String redirect() {
		return "redirect:/cloud/login";
	}
	
	@GetMapping("/cloud/user/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/cloud/admin/main")
	public String mainAdmin() {
		return "/admin/adminMain";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

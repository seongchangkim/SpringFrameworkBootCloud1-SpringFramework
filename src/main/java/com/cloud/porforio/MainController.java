package com.cloud.porforio;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String redirect() {
		return "redirect:/cloud/";
	}
	
	@GetMapping("/cloud/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/cloud/admin/")
	public String mainAdmin() {
		return "main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

package com.cloud.porforio;

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
}

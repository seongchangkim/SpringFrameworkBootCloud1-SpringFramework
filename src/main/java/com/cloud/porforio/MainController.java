package com.cloud.porforio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/cloud/")
	public String main() {
		return "main";
	}
	
	
	@GetMapping(value="/login")
	public String login(){
		return "login";
	}
	
}

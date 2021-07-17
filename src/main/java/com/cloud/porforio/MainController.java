package com.cloud.porforio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cloud")
public class MainController {
	
	@GetMapping(value = "/user/main")
	public String main() {
		return "main";
	}
	
	
}

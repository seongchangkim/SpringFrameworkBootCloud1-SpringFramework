package com.cloud.porforio;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cloud.porforio.domain.FileDTO;
import com.cloud.porforio.service.FileUpDownLoadService;

@Controller
public class MainController {

	@Autowired
	private FileUpDownLoadService service;
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/cloud/login";
	}
	
	@GetMapping("/cloud/user/main")
	public String main(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id="";
		if(principal != null){
			id = auth.getName();
		}
		
		List<FileDTO> list = service.getFileList(id);
		model.addAttribute("list",list);
		return "main";
	}
	
	@GetMapping("/cloud/admin/main")
	public String mainAdmin(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id="";
		if(principal != null){
			id = auth.getName();
		}
		
		List<FileDTO> list = service.getFileList(id);
		model.addAttribute("list",list);
		return "main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

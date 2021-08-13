package com.cloud.porforio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.porforio.domain.FileDTO;
import com.cloud.porforio.service.FileUpDownLoadService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cloud/*")
@Log4j
public class FileUpDownLoadController {
	
	@Autowired
	private FileUpDownLoadService service;
	
	@PostMapping("/upload")
	public String upload(@ModelAttribute FileDTO file, @RequestParam("files") MultipartFile[] files, HttpServletRequest request, Model model) throws IllegalStateException, IOException {
		
		log.warn(file.getId());
		service.fileUpLoadProcess(file, files ,request);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id = "";
		if(principal != null) {
			id = auth.getName();
		}
		
		List<FileDTO> list = service.getFileList(id);
		model.addAttribute("list",list);
		return "main";
	}

	
}

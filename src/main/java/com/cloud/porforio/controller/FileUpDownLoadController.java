package com.cloud.porforio.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String upload(@ModelAttribute FileDTO file, @RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException {
		
		log.warn(file.getId());
		service.fileUpLoadProcess(file, files ,request);
		
		return "main";
	}
	
}

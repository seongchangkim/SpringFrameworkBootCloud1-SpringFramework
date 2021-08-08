package com.cloud.porforio.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.domain.FileDTO;
import com.cloud.porforio.service.FileUpDownLoadService;

@Controller
@RequestMapping("/cloud/*")
public class FileUpDownLoadController {
	
	@Autowired
	private FileUpDownLoadService service;
	
	@PostMapping("/upload")
	public String upload(FileDTO file, MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request) throws IllegalStateException, IOException {
		service.fileUpLoadProcess(file,multipartHttpServletRequest, request);
		
		return "main";
	}
	
}

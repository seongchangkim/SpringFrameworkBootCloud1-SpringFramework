package com.cloud.porforio.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String upload(@ModelAttribute FileDTO file, @Nullable MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request) throws IllegalStateException, IOException {
		log.warn("" + request.getParameterValues("files"));
		service.fileUpLoadProcess(file,multipartHttpServletRequest, request);
		
		return "main";
	}
	
}

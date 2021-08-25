package com.cloud.porforio.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
		
		String userAuth = service.selectUserAuth(id);
		String path = "";
		
		if(userAuth.equals("ROLE_USER")) {
			path = "/user/";
		}else {
			path = "/admin/";
		}
		return "redirect:/cloud" + path + "main";
	}

	//파일 다운로드(2021.08.14)
	@GetMapping(value="/download")
	public ModelAndView download(int fno,HttpServletRequest request) {
		FileDTO file = service.selectFile(fno);
		
		String filePath = file.getStoredFilePath();
		File downloadFile = new File(filePath);
		
		return new ModelAndView("fileDownloadView","downloadFile", downloadFile);
	}
	
	@GetMapping(value="/deleteYNUpdateFile")
	public String deleteYNUpdateFile(int fno, Model model) {
		boolean isDeleteYNUpdateFile = service.isDeleteYNUpdateFile(fno);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id = "";
		if(principal != null) {
			id = auth.getName();
		}
		
		String userAuth = service.selectUserAuth(id);
		String path = "";
		
		if(userAuth.equals("ROLE_USER")) {
			path = "/user/";
		}else {
			path = "/admin/";
		}
		return "redirect:/cloud" + path + "main";
	}
	
	@GetMapping(value="/fileKeyWord")
	public String fileKeyWord(@RequestParam("keyword") String keyWord, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id="";
		if(principal != null){
			id = auth.getName();
		}
		
		List<FileDTO> list = service.getKeyWordFileList(keyWord);
		int totalFileSize = service.getFileSize(id);
		
		model.addAttribute("totalFileSize",totalFileSize);
		model.addAttribute("list",list);
		return "main";
	}
	
	@GetMapping(value="/recycleBin")
	public String recycleBinForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id = "";
		if(principal != null) {
			id = auth.getName();
		}
		
		List<FileDTO> list = service.getDeleteYNYFileList(id);
		model.addAttribute("list",list);
		return "/recycleBin/recycleForm";
	}
	
	@GetMapping(value="/emptytrash")
	public String emptyTrash(int fno, Model model) {
		boolean isDeleteEmptyTrash = service.isDeleteEmptyTrash(fno);
		
		return "redirect:/cloud/recycleBin";
	}
	
	@GetMapping(value="/restore")
	public String restore(int fno, Model model) {
		boolean isRestoreFile = service.isRestoreFile(fno);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String id = "";
		if(principal != null) {
			id = auth.getName();
		}
		
		String userAuth = service.selectUserAuth(id);
		String path = "";
		
		if(userAuth.equals("ROLE_USER")) {
			path = "/user/";
		}else {
			path = "/admin/";
		}
		return "redirect:/cloud" + path + "main";
	}
}

package com.cloud.porforio.commons.util;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.FileDTO;

import lombok.extern.log4j.Log4j;

//@Resource를 통해서 Component 값을 가져오기 위해 Component 이름 지정  
@Component("fileUtils")
@Log4j
public class FileUtils {
	
	public List<BoardFile> parseFileInfo(int bno, MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request)
			throws IllegalStateException, IOException {
		log.warn(ObjectUtils.isEmpty(multipartHttpServletRequest));
		if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}

		List<BoardFile> fileList = new ArrayList<>();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");

		ZonedDateTime current = ZonedDateTime.now();
	
		String path = request.getSession().getServletContext().getRealPath("/") + "resources\\images\\" + current.format(format);
		
		File file = new File(path);

		if (file.exists() == false) {
			file.mkdirs();
		}

		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		String newFileName, originalFileExtension = "", contentType;

		while (iterator.hasNext()) {
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
			for (MultipartFile multipartFile : list) {
		
				if (multipartFile.isEmpty() == false) {
					
					contentType = multipartFile.getContentType();

					if (ObjectUtils.isEmpty(contentType)) {
						break;
					} else {
						if (contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if (contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if (contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else {
							break;
						}
					}
					
					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

					BoardFile boardFile = new BoardFile();

					boardFile.setBno(bno);
					boardFile.setFilesize(multipartFile.getSize());
					boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
					boardFile.setStoredFilePath(path + "\\" + newFileName);

					fileList.add(boardFile);

					file = new File(path + "\\" + newFileName);

					multipartFile.transferTo(file);
				}
			}
		}
		return fileList;
	}
	
	public List<FileDTO> parseFileList(String id, MultipartFile[] files, HttpServletRequest request)
			throws IllegalStateException, IOException {
		List<FileDTO> fileList = new ArrayList<>();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		ZonedDateTime current = ZonedDateTime.now();
		
		String path = request.getSession().getServletContext().getRealPath("/") + "resources\\files\\" + id + "\\" + current.format(format);
		
		File file = new File(path);
		
		log.warn(file.exists());
		if(file.exists() == false) {
			log.warn(1);
			file.mkdirs();
		}
		
		String newFileName, originalFileExtension = "", contentType = "";
		
		for(MultipartFile multipartFile : files) {
				if(multipartFile.isEmpty() == false) {
					contentType = multipartFile.getContentType();
					
					if(ObjectUtils.isEmpty(contentType)) {
						break;
					}else {
						if(contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						}else if(contentType.contains("image/png")) {
							originalFileExtension = ".png";
						}else if(contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						}else if(contentType.contains("application/pdf")) {
							originalFileExtension = ".pdf";
						}else if(contentType.contains("application/vnd.ms-powerpoint")) {
							originalFileExtension = ".ppt";
						}else if(contentType.contains("application/x-rar-compressed")) {
							originalFileExtension = ".rar";
						}else if(contentType.contains("application/x-tar")) {
							originalFileExtension = ".tar";
						}else if(contentType.contains("application/vnd.ms-excel")) {
							originalFileExtension = ".zip";
						}else if(contentType.contains("application/x-7z-compressed")) {
							originalFileExtension = ".7z";
						}else if(contentType.contains("audio/mpeg")) {
							originalFileExtension = ".mp3";
						}else if(contentType.contains("text/plain")) {
							originalFileExtension = ".txt";
						}else if(contentType.contains("application/msword")) {
							originalFileExtension = ".doc";
						}else if(contentType.contains("video/x-msvideo")) {
							originalFileExtension = ".avi";
						}else if(contentType.contains("video/mp4")) {
							originalFileExtension = ".mp4";
						}else {
							break;
						}
						
						newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
						
						FileDTO fileDTO = new FileDTO();
						fileDTO.setId(id);
						fileDTO.setOriginalFileName(multipartFile.getOriginalFilename());
						fileDTO.setStoredFilePath(path + "\\" + newFileName);
						fileDTO.setFileSize(multipartFile.getSize());
						fileList.add(fileDTO);
						log.info(fileDTO);
						file = new File(path + "\\" + newFileName);
						
						multipartFile.transferTo(file);
					}
				}
			}
		
		return fileList;
	}
	
	//2021.09.01 파일 삭제
	public boolean isRemoveFile(FileDTO file) {
		String storedFilePath = file.getStoredFilePath();
		
		File deleteFile = new File(storedFilePath);
		
		if(deleteFile.exists()) {
			deleteFile.delete();
			return true;
		}else {
			return false;
		}
		
	}
	
	//2021.09.01 게시판 파일 삭제
	public boolean isRemoveBoardFile(List<BoardFile> fileList) {
		
		for(int i = 0; i<fileList.size() ; i++) {
			String storedFilePath = fileList.get(i).getStoredFilePath();
			
			File deleteFile = new File(storedFilePath);
				
			if(deleteFile.exists()) {
				fileList.remove(i);
				deleteFile.delete();
				i--;
			}
//			log.warn(fileList);
		}
//		log.warn(fileList);
//		log.warn(fileList.size());
		
		if(fileList.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}


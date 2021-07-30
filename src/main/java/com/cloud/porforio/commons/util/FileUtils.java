package com.cloud.porforio.commons.util;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.domain.BoardFile;

@Component
public class FileUtils {
	
	public List<BoardFile> parseFileInfo(int bno, MultipartHttpServletRequest multipartHttpServletRequest) throws IllegalStateException, IOException{
		
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}
		
		List<BoardFile> fileList = new ArrayList<>();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		ZonedDateTime current = ZonedDateTime.now();
		
		String path = "images/" + current.format(format);
		
		File file = new File(path);
		
		if(file.exists() == false) {
			file.mkdir();
		}
		
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		String newFileName, originalFileExtension = "", contentType;
		
		while(iterator.hasNext()) {
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
			
			for(MultipartFile multipartFile : list) {
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
						}else {
							break;
						}
					}
				}
				
				newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
				
				BoardFile boardFile = new BoardFile();
				
				boardFile.setBno(bno);
				boardFile.setFilesize(multipartFile.getOriginalFilename());
				boardFile.setStoredFileName(path + "/" + newFileName);
				
				fileList.add(boardFile);
				
				file = new File(path + "/" + newFileName);
				
				multipartFile.transferTo(file);
			}
		}
		
		return fileList;
	}
}


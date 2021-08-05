package com.cloud.porforio.commons.util;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.domain.BoardFile;

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
}


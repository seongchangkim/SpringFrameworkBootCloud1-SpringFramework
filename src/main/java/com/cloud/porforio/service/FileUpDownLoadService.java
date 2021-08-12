package com.cloud.porforio.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cloud.porforio.domain.FileDTO;

public interface FileUpDownLoadService {
	void fileUpLoadProcess(FileDTO file, MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException;
}

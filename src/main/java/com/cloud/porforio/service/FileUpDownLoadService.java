package com.cloud.porforio.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.domain.FileDTO;

public interface FileUpDownLoadService {
	void fileUpLoadProcess(FileDTO file, MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request) throws IllegalStateException, IOException;
}

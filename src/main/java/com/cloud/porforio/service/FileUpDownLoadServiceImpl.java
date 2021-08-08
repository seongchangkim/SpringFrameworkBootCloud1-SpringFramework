package com.cloud.porforio.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.commons.util.FileUtils;
import com.cloud.porforio.domain.FileDTO;
import com.cloud.porforio.mapper.FileUpDownLoadMapper;

@Service
public class FileUpDownLoadServiceImpl implements FileUpDownLoadService{

	@Autowired
	private FileUpDownLoadMapper mapper;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Override
	public void fileUpLoadProcess(FileDTO file, MultipartHttpServletRequest multipartHttpServletRequest,
			HttpServletRequest request) throws IllegalStateException, IOException {
		List<FileDTO> list = fileUtils.parseFileList(multipartHttpServletRequest, request);
		
		mapper.fileUpLoadProcess(list);
	}

}

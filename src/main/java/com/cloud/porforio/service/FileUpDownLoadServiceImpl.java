package com.cloud.porforio.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.porforio.commons.util.FileUtils;
import com.cloud.porforio.domain.FileDTO;
import com.cloud.porforio.mapper.FileUpDownLoadMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class FileUpDownLoadServiceImpl implements FileUpDownLoadService{

	@Autowired
	private FileUpDownLoadMapper mapper;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Override
	public void fileUpLoadProcess(FileDTO file, MultipartFile[] files,
			HttpServletRequest request) throws IllegalStateException, IOException {
		log.warn(files.length);
		List<FileDTO> list = fileUtils.parseFileList(file.getId(), files ,request);
		log.warn(list);
		mapper.fileUpLoadProcess(list);
	}

	@Override
	public List<FileDTO> getFileList(String id) {
		return mapper.getFileList(id);
	}

	@Override
	public FileDTO selectFile(int fno) {
		return mapper.selectFile(fno);
	}

	@Override
	public boolean isDeleteYNUpdateFile(int fno) {
		return mapper.deleteYNUpdateFile(fno) == 1;
	}

	@Override
	public List<FileDTO> getDeleteYNYFileList(String id) {
		return mapper.getDeleteYNYFileList(id);
	}

	@Override
	public boolean isDeleteEmptyTrash(int fno) {
		return mapper.deleteEmptyTrash(fno) == 1;
	}

	@Override
	public boolean isRestoreFile(int fno) {
		return mapper.restoreFile(fno) == 1;
	}

}

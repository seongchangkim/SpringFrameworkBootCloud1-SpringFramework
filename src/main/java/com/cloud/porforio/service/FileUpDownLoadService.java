package com.cloud.porforio.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cloud.porforio.domain.FileDTO;

public interface FileUpDownLoadService {
	void fileUpLoadProcess(FileDTO file, MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException;

	List<FileDTO> getFileList(String id);

	FileDTO selectFile(int fno);
	
	boolean isDeleteYNUpdateFile(int fno);
	
	List<FileDTO> getDeleteYNYFileList(String id);

	boolean isDeleteEmptyTrash(int fno);
	
	boolean isRestoreFile(int fno);
	
	String selectUserAuth(String id);
}

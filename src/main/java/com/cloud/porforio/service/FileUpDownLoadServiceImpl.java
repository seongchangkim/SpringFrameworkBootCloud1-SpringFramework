package com.cloud.porforio.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		Map<String, String> map = new HashMap<>(); 
		List<String> fileNameList = mapper.getFileNameList();
		List<FileDTO> list = fileUtils.parseFileList(file.getId(), files ,request);
		String[] uploadUserList = mapper.getUploadUserList(file.getOriginalFileName());
		
		for(String a: uploadUserList) {
			map.put(a, file.getOriginalFileName());
		}
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>)it.next();
			if(e.getKey().equals(file.getId())) {
				
			}
		}
		
		 for(int i = 0; i<fileNameList.size() ; i++) {
			for(int j = 0; j<list.size() ; j++) {
				if(file.getId().equals(file.getId()) && fileNameList.get(i).equals(list.get(j).getOriginalFileName())) {
					list.remove(j);
				}
			}
		}
		
		if(list.size() > 0) {
			mapper.fileUpLoadProcess(list);
		}
		
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

	@Override
	public String selectUserAuth(String id) {
		return mapper.selectUserAuth(id);
	}

	@Override
	public List<FileDTO> getKeyWordFileList(String keyWord) {
		return mapper.getKeyWordFileList(keyWord);
	}

	@Override
	public int getFileSize(String id) {
		int[] fileSizeArray = mapper.getFileSize(id);
		int sum = 0;
		for(int i : fileSizeArray) {
			sum += i;
		}
		return sum;
	}

}

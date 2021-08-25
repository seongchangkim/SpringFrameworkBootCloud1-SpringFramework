package com.cloud.porforio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.FileDTO;

@Mapper
public interface FileUpDownLoadMapper {
	
	public void fileUpLoadProcess(List<FileDTO> list);

	public List<FileDTO> getFileList(@Param("id") String id);

	public FileDTO selectFile(@Param("fno") int fno);

	public int deleteYNUpdateFile(@Param("fno") int fno);

	public List<FileDTO> getDeleteYNYFileList(@Param("id") String id);

	public int deleteEmptyTrash(@Param("fno") int fno);

	public int restoreFile(@Param("fno") int fno);
	
	public List<String> getFileNameList();
	
	public String selectUserAuth(@Param("id") String id);
	
	public List<FileDTO> getKeyWordFileList(@Param("keyword") String keyWord);

	public int[] getFileSize(@Param("id") String id);
	
	public String[] getUploadUserList(@Param("originalfilename") String originalFileName);
}

package com.cloud.porforio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.FileDTO;

@Mapper
public interface FileUpDownLoadMapper {
	
	public void fileUpLoadProcess(List<FileDTO> list);

	public List<FileDTO> getFileList(@Param("id") String id);
}

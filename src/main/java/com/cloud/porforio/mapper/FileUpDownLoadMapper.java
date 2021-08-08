package com.cloud.porforio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cloud.porforio.domain.FileDTO;

@Mapper
public interface FileUpDownLoadMapper {
	
	public void fileUpLoadProcess(List<FileDTO> list);
}

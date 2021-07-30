package com.cloud.porforio.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;

@Mapper
public interface BoardMapper {
	
	public List<Board> list();
	
	public String selectName(@Param("id") String id);
	
	public void add(Board board);
	
	public void addFile(List<BoardFile> file);
}

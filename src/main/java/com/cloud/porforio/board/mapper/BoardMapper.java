package com.cloud.porforio.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cloud.porforio.domain.Board;

@Mapper
public interface BoardMapper {
	
	public List<Board> list();
}

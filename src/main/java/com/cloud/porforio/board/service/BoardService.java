package com.cloud.porforio.board.service;

import java.util.List;

import com.cloud.porforio.domain.Board;

public interface BoardService {

	List<Board> list();
	
	String selectName(String id);
}

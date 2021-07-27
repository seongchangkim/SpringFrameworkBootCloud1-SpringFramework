package com.cloud.porforio.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.porforio.board.mapper.BoardMapper;
import com.cloud.porforio.domain.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<Board> list() {
		return mapper.list();
	}

}

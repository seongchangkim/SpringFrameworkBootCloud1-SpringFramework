package com.cloud.porforio.board.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.board.mapper.BoardMapper;
import com.cloud.porforio.commons.util.FileUtils;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public List<Board> list() {
		return mapper.list();
	}

	@Override
	public String selectName(String id) {
		return mapper.selectName(id);
	}

	@Override
	public void add(Board board, MultipartHttpServletRequest multipartHttpServlet) throws IllegalStateException, IOException {
		
		mapper.add(board);
		
		List<BoardFile> list = fileUtils.parseFileInfo(board.getBno(), multipartHttpServlet);
		
		if(CollectionUtils.isEmpty(list)) {
			mapper.addFile(list);
		}
		
	}
}

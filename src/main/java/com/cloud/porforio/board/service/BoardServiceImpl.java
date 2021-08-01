package com.cloud.porforio.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.board.mapper.BoardMapper;
import com.cloud.porforio.commons.util.FileUtils;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Resource(name="fileUtils")
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
	public void add(Board board, MultipartHttpServletRequest multipartHttpServlet) throws Exception {
		
		mapper.add(board);
		log.warn(board.getBno());
		
		List<BoardFile> list = fileUtils.parseFileInfo(board.getBno(), multipartHttpServlet);
		
		log.warn(list.get(0).getBno());
		log.warn(new BoardFile().getBno());
		
		if(CollectionUtils.isEmpty(list) == false) {
			mapper.addFile(list);
		}
		
	}
}

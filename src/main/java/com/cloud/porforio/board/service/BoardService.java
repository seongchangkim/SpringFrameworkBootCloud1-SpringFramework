package com.cloud.porforio.board.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.domain.Board;


public interface BoardService {

	List<Board> list();
	
	String selectName(String id);
	
	void add(Board board, MultipartHttpServletRequest multipartHttpServlet) throws IllegalStateException, IOException;
	
}

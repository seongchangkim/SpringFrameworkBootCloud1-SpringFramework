package com.cloud.porforio.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.Criteria;
import com.cloud.porforio.domain.Reply;

public interface BoardService {

	List<Board> list(Criteria cri);
	
	String selectName(String id);
	
	void add(Board board, MultipartHttpServletRequest multipartHttpServlet, HttpServletRequest request) throws Exception;
	
	void updateReadCount(int bno);
	
	Board selectBoard(int bno);
	
	ArrayList<BoardFile> selectBoardFileList(int bno);
	
	boolean updateBoard(Board board);
	
	boolean deleteBoard(int bno);
	
	int getTotal(Criteria cri);
	
	ArrayList<Reply> selectReplyList(int bno); 

	BoardFile selectBoardFile(int idx);
}

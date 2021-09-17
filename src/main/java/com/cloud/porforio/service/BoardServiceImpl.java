package com.cloud.porforio.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cloud.porforio.commons.util.FileUtils;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.Criteria;
import com.cloud.porforio.domain.Reply;
import com.cloud.porforio.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	
	//@Autowired가 아니라 @Resource 해야 fileUtils 객체를 바인딩할 수 있어서 파일 업로드 가능
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Override
	public List<Board> list(Criteria cri) {
		return mapper.list(cri);
	}

	@Override
	public String selectName(String id) {
		return mapper.selectName(id);
	}

	@Override
	public void add(Board board, MultipartHttpServletRequest multipartHttpServlet, HttpServletRequest request) throws Exception {
		
		mapper.add(board);
		List<BoardFile> list = fileUtils.parseFileInfo(board.getBno(), multipartHttpServlet, request);
		
		if(CollectionUtils.isEmpty(list) == false) {
			mapper.addFile(list);
		}
		
	}

	@Override
	public void updateReadCount(int bno) {
		mapper.updateReadCount(bno);
	}

	@Override
	public Board selectBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean updateBoard(Board board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean deleteBoard(int bno) {
		List<BoardFile> fileList = mapper.selectBoardFileList(bno);
		
		boolean isRemoveBoardFile = fileUtils.isRemoveBoardFile(fileList);
		
		log.warn(isRemoveBoardFile);
		if(isRemoveBoardFile) {
			return mapper.deleteBoard(bno) == 1;
		}else {
			return false;
		}
	
	}

	@Override
	public ArrayList<BoardFile> selectBoardFileList(int bno) {
		return mapper.selectBoardFileList(bno);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}

	@Override
	public ArrayList<Reply> selectReplyList(int bno) {
		return mapper.selectReplyList(bno);
	}

	@Override
	public BoardFile selectBoardFile(int idx) {
		return mapper.selectBoardFile(idx);
	}
}

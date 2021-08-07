package com.cloud.porforio.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.porforio.board.mapper.ReplyMapper;
import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public void add(Reply reply) {
		mapper.add(reply);
	}

	@Override
	public Board selectBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public BoardFile selectBoardFile(int bno) {
		return mapper.selectBoardFile(bno);
	}

	@Override
	public boolean updateReply(Reply reply) {
		return mapper.updateReply(reply) == 1;
	}

	@Override
	public boolean deleteReply(int rno) {
		return mapper.deleteReply(rno) == 1;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int bno) {
		return mapper.selectReplyList(bno);
	}

}

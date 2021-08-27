package com.cloud.porforio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.Reply;
import com.cloud.porforio.mapper.ReplyMapper;

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

	@Override
	public boolean upUpdateReplyCount(int bno) {
		return mapper.upUpdateReplyCount(bno) == 1;
	}

	@Override
	public boolean downUpdateReplyCount(int bno) {
		return mapper.downUpdateReplyCount(bno) == 1;
	}

	@Override
	public String selectName(String id) {
		return mapper.selectName(id);
	}

	@Override
	public int selectBno(int rno) {
		return mapper.selectBno(rno);
	}

}

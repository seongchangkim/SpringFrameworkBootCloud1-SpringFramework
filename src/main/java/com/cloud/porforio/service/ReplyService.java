package com.cloud.porforio.service;

import java.util.ArrayList;

import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.Reply;

public interface ReplyService {
	void add(Reply reply);
	
	Board selectBoard(int bno);
	
	
	
	boolean updateReply(Reply reply);
	
	boolean deleteReply(int rno);
	
	ArrayList<Reply> selectReplyList(int bno);
	
	boolean upUpdateReplyCount(int bno);
	
	boolean downUpdateReplyCount(int bno);
	
	String selectName(String id);
	
	int selectBno(int rno);
}

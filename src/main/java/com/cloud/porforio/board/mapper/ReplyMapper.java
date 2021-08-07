package com.cloud.porforio.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.Reply;

@Mapper
public interface ReplyMapper {
	public void add(Reply reply);
	
	public Board selectBoard(@Param("bno") int bno);
	
	public BoardFile selectBoardFile(@Param("bno") int bno);

	public int updateReply(Reply reply);
	
	public int deleteReply(@Param("rno") int rno);
	
	public ArrayList<Reply> selectReplyList(@Param("bno") int bno);
}

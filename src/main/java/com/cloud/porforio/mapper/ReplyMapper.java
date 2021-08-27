package com.cloud.porforio.mapper;

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

	public int updateReply(Reply reply);
	
	public int deleteReply(@Param("rno") int rno);
	
	public ArrayList<Reply> selectReplyList(@Param("bno") int bno);
	
	public int upUpdateReplyCount(@Param("bno") int bno);

	public int downUpdateReplyCount(@Param("bno") int bno);

	public String selectName(@Param("id") String id);
	
	public int selectBno(@Param("rno") int rno);
}

package com.cloud.porforio.board.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.porforio.domain.Board;
import com.cloud.porforio.domain.BoardFile;
import com.cloud.porforio.domain.Criteria;
import com.cloud.porforio.domain.Reply;

@Mapper
public interface BoardMapper {
	
	public List<Board> list(Criteria cri);
	
	public String selectName(@Param("id") String id);
	
	public void add(Board board);
	
	public void addFile(List<BoardFile> file);
	
	public void updateReadCount(@Param("bno") int bno);
	
	public Board selectBoard(@Param("bno") int bno);
	
	public ArrayList<BoardFile> selectBoardFileList(@Param("bno") int bno);
	
	public int updateBoard(Board board);
	
	public int deleteBoardFile(@Param("bno") int bno);
	
	public int deleteBoard(@Param("bno") int bno);
	
	public int getTotal(Criteria cri);
	
	public ArrayList<Reply> selectReplyList(@Param("bno") int bno);

	public BoardFile selectBoardFile(@Param("idx") int idx);
}

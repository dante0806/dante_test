package com.dante.main.develop.board;

import java.util.List;
import java.util.Map;

import com.dante.main.domain.board.Board;
import com.dante.main.domain.board.BoardReply;

public interface BoardService {
		
		//게시판
		List<Board> getBoardList();
		
		void insertBoard(Board board);
		
		int updateBoard(Map<String, Object> param);
		
		void deleteBoard(Long id);
		
		//게시판 댓글
		List<BoardReply> getBoardReplyList(Long board_id);
		
		void insertBoardReply(Map<String, Object> param);
		
		int deleteBoardReply(Long board_id);
}

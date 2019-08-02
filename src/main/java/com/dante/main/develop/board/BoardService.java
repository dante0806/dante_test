package com.dante.main.develop.board;

import java.util.List;

import com.dante.main.domain.board.Board;

public interface BoardService {
		
		List<Board> getBoardList();
		
		void insertBoard(Board board);
		
		void updateBoard(Board board);
		
		void deleteBoard(Long id);
}

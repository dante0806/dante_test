package com.dante.main.develop.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dante.main.domain.board.Board;
import com.dante.main.domain.board.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public void saveBoard(Board board) {		
		boardRepository.save(board);
	}

	/*@Override
	public Board findByBoard_id(Long board_id) {
		return boardRepository.findByBoard_id(board_id);
	}*/

		
}

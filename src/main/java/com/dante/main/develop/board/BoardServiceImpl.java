package com.dante.main.develop.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dante.main.domain.board.Board;
import com.dante.main.domain.board.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public void insertBoard(Board board) {		
		boardRepository.save(board);
	}

	@Override
	public List<Board> getBoardList() {
		return boardRepository.findAll();
	}
	
	@Transactional
	@Override
	public void updateBoard(Map<String, Object> param){
		Board board = new Board();
		board.setId(Long.parseLong(String.valueOf(param.get("board_id"))));
		board.setBoard_title(String.valueOf(param.get("board_title")));
		board.setBoard_content(String.valueOf(param.get("board_content")));
		boardRepository.update(board);
	}

	@Override
	public void deleteBoard(Long id){
		boardRepository.deleteById(id);
	}
	
}

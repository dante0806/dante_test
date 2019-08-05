package com.dante.main.develop.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dante.main.domain.board.Board;
import com.dante.main.domain.board.BoardReply;
import com.dante.main.domain.board.BoardReplyRepository;
import com.dante.main.domain.board.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardReplyRepository boardReplyRepository;

	//게시판 등록
	@Override
	public void insertBoard(Board board) {		
		boardRepository.save(board);
	}

	//게시판 리스트
	@Override
	public List<Board> getBoardList() {
		return boardRepository.findAll();
	}
	
	//게시판 수정
	@Transactional
	@Override
	public int updateBoard(Map<String, Object> param){
		Board board = new Board();
		board.setId(Long.parseLong(String.valueOf(param.get("board_id"))));
		board.setBoard_title(String.valueOf(param.get("board_title")));
		board.setBoard_content(String.valueOf(param.get("board_content")));
		int result = boardRepository.update(board);
		return result;
	}

	//게시판 삭제
	@Override
	public void deleteBoard(Long id){
		boardRepository.deleteById(id);
	}
	
	//게시판 댓글 리스트
	@Override
	public	List<BoardReply> getBoardReplyList(Long board_id){
		
		return boardReplyRepository.getBoardReplyList(board_id);
	}
			
	//게시판 댓글 등록
	@Override
	public void insertBoardReply(Map<String, Object> param){
		BoardReply boardReply = new BoardReply();
		boardReply.setBoard_id(Long.parseLong(String.valueOf(param.get("board_id"))));
		boardReply.setBoard_reply_content(String.valueOf(param.get("board_reply_content")));
		boardReply.setUser_id(String.valueOf(param.get("user_id")));
		
		boardReplyRepository.save(boardReply);
	}
	
	//게시글 삭제시 댓글 모두 삭제
	@Override
	public int deleteBoardReply(Long board_id){
		int result = boardReplyRepository.delBoardReplyByBoard_id(board_id);
		return result;
	}
}

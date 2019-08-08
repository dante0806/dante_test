package com.dante.main.develop.board;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dante.main.domain.board.Board;
import com.dante.main.domain.board.BoardReply;
import com.dante.main.domain.board.BoardReplyRepository;
import com.dante.main.domain.board.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardReplyRepository boardReplyRepository;
	
	//게시물 리스트 페이지
	@GetMapping("/boardList")
	public ModelAndView boardList(@PageableDefault(sort = {"id"}, direction = Direction.DESC, size=2) final Pageable pageable ){
		ModelAndView mv = new ModelAndView();
		Page<Board> boardPage = boardRepository.findAll(pageable);
		mv.addObject("boardPage", boardPage);
		mv.setViewName("main/board/boardList");
		return mv;
	}
	
	//게시물 등록/수정 페이지
	@GetMapping("/boardWrite")
	public ModelAndView boardWrite(@RequestParam("board_id") Long id){
		ModelAndView mv = new ModelAndView();
		if(id !=null){
			//게시글 fetch
			Optional<Board> board = boardRepository.findById(id);
			mv.addObject("board", board.get());
			
			//댓글 fetch
			List<BoardReply> boardReplyList = boardService.getBoardReplyList(id);			
			if(boardReplyList.size() >0){
				mv.addObject("boardReplyList",boardReplyList);
			}
			
		}
		mv.setViewName("main/board/boardWrite");
		return mv;
	}
	
	//게시물 등록 
	@PostMapping("/regBoard")
	public ModelAndView regBoard(@ModelAttribute("boardForm") Board boardForm){
		
		ModelAndView mv = new ModelAndView();
		boardService.insertBoard(boardForm);
		mv.setViewName("redirect:/boardList");
		return mv;
	}
	
	//게시물 수정
	@ResponseBody
	@PostMapping("/modifyBoard")
	public int modifyBoard(@RequestBody Map<String, Object> param){
		
		int result = boardService.updateBoard(param);
		return result;
	}
	
	//게시물 삭제
	@Transactional
	@GetMapping("/delBoard")
	public ModelAndView delBoard(String board_id){
		ModelAndView mv = new ModelAndView();
		Long id = Long.parseLong(board_id);
		boardService.deleteBoard(id);
		boardService.deleteBoardReply(id);
		mv.setViewName("redirect:/boardList");
		return mv;
	}
	
	//댓글 등록
	@Transactional
	@ResponseBody
	@PostMapping("/regBoardReply")
	public List<BoardReply> regBoardReply(@RequestBody Map<String, Object> param){
		
		boardService.insertBoardReply(param);
		//댓글 fetch
		Long board_id = Long.parseLong(String.valueOf(param.get("board_id")));
		List<BoardReply> boardReplyList = boardService.getBoardReplyList(board_id);
		
		return boardReplyList;
	}
	
	//댓글 삭제
	@Transactional
	@ResponseBody
	@PostMapping("/delBoardReply")
	public int delBoardReply(@RequestBody Long id){
		int result = 0; 
		try {
			boardReplyRepository.deleteById(id);
			result = 1;
		} catch (Exception e) {
		}
		return result;
	} 
}

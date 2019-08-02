package com.dante.main.develop.board;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dante.main.domain.board.Board;
import com.dante.main.domain.board.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardRepository boardRepository;
	
	//게시물 리스트 페이지
	@GetMapping("/boardList")
	public ModelAndView boardList(){
		ModelAndView mv = new ModelAndView();
		List<Board> boardList = boardRepository.findAll();
		mv.addObject("boardList", boardList);
		mv.setViewName("main/board/boardList");
		return mv;
	}
	
	//게시물 등록/수정 페이지
	@GetMapping("/boardWrite")
	public ModelAndView boardWrite(@RequestParam("board_id") Long id){
		ModelAndView mv = new ModelAndView();
		if(id !=null){
			Optional<Board> board = boardRepository.findById(id);
			System.out.println(" board >> " +board.get());
			mv.addObject("board", board.get());
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
	public ModelAndView modifyBoard(@ModelAttribute("boardForm") Board board){
		
		ModelAndView mv = new ModelAndView();
		boardService.updateBoard(board);
		mv.setViewName("redirect:/boardList");
		return mv;
	}
	
	//게시물 삭제
	@GetMapping("/delBoard")
	public ModelAndView delBoard(String board_id){
		ModelAndView mv = new ModelAndView();
		Long id = Long.parseLong(board_id);
		boardService.deleteBoard(id);
		mv.setViewName("redirect:/boardList");
		return mv;
	}
	
}

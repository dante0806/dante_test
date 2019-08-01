package com.dante.main.develop.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dante.main.domain.board.Board;
import com.dante.main.domain.board.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/boardList")
	public ModelAndView boardList(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardRepository.findAll());
		mv.setViewName("main/board/boardList");
		return mv;
	}
	
	@GetMapping("/boardWrite")
	public ModelAndView boardWrite(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/board/boardWrite");
		return mv;
	}
	
	//게시물 등록 후 리스트로
	@PostMapping("/regBoard")
	public ModelAndView regBoard(@ModelAttribute("boardForm") Board boardForm){
		
		ModelAndView mv = new ModelAndView();
		boardService.saveBoard(boardForm);
		mv.setViewName("redirect:/boardList");
		return mv;
	}
}

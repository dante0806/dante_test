package com.dante.main.develop.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@GetMapping("/boardList")
	public ModelAndView boardList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/board/boardList");
		return mv;
	}
	
	@GetMapping("/boardWrite")
	public ModelAndView boardWrite(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/board/boardWrite");
		return mv;
	}
}

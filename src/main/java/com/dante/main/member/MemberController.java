package com.dante.main.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberController {

	//로그인 페이지
	@GetMapping("/login")
	public ModelAndView  ViewLoginPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/member/login");
		
		return mv;
	}
	
	//회원가입 페이지
	@GetMapping("/signUp")
	public ModelAndView  ViewSignUpPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/member/signUp");
		
		return mv;
	}
	
}

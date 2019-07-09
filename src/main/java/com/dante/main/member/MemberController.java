package com.dante.main.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dante.main.domain.member.MemberDto;
import com.dante.main.domain.member.MemberRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberController {

	private MemberRepository memberRepository;
	
	private MemberService memberService;
	
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
	
	@PostMapping("/regMember")
	public Long regMember(@RequestBody MemberDto dto){
	//	memberRepository.save(dto.toEntity());
		return memberService.save(dto);
	}
	
	
}

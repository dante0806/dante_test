package com.dante.main.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//VV아래부터는 테스트
	@RequestMapping(value="/main")
	public String main(){
		return "main";
	}
	  
	// 로그인 
	@RequestMapping("/login")
	public String login(Model model, String error, String logout, HttpServletRequest request ){
		if (logout != null){
			model.addAttribute("logout", "You have been logged out successfully.");
		}
		return "login";
	}
	  
	// 로그인 실패시
	@RequestMapping(value="/loginError")
	public String loginError(Model model, String username ){
		model.addAttribute("error", "Your username and password is invalid.");
		model.addAttribute("username",username);
		return "login";
	}
	  
	// 회원가입폼 
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String registration(Model model){
		model.addAttribute("userForm", new User());
		return "registration";
	}
  
	// 회원가입 처리 후 로그인 
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, 
			Model model ,String[] roles ){
		String password = userForm.getPassword();
		userService.saveUser(userForm,roles);
		securityService.autologin(userForm.getUsername(),password);
		return "redirect:/main";
	}
  
	// admin 사용자 테스트 
	@RequestMapping("/admin")
	public String admin(){
		return "/admin/admin";
	}
  
	// user 사용자 테스트 
	@RequestMapping("/user")
	public String user(){
		return "/user/user";
	}
  
	// 권한없는 페이지를 들어갔을때 
	@RequestMapping("/403")
	public String access(){
		return "/access";
	}
	
}

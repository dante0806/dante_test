package com.dante.main.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dante.main.domain.user.User;
import com.dante.main.security.SecurityService;
import com.dante.main.user.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Controller
@AllArgsConstructor
public class UserController {
	
	@Autowired
	UserService userService;
  
	@Autowired
	private SecurityService securityService;
  
	// 로그인
	@GetMapping("/login")
	public ModelAndView login(String error, String logout, HttpServletRequest request ){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/member/login");		
	    return mv;
	}
	
	// 로그인 프로세스
	@PostMapping("/loginProcess")
	public void loginProcess(Model model, String error, String logout, HttpServletRequest request ){
	}
  
	// 로그인 실패시
	@GetMapping("/loginError")
	public ModelAndView loginError(String username ){
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
		mv.addObject("user_id", username);
		mv.setViewName("login");
		return mv;
	}
  
	// 회원가입폼
	@GetMapping("/signUp")
	public ModelAndView signUp(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("userFrom", new User());
		mv.setViewName("main/member/signUp");
		return mv;
	}
	  
	@PostMapping("/getUser")
	public ResponseEntity<?> getUserEntity(@RequestBody Map<String,Object> params) throws Exception{
		User userEntity = userService.findByUsername(String.valueOf(params.get("username")));
		//return ResponseEntity.ok(userEntity);
		return null;
	} 
  
	// 회원가입 처리 후 로그인
	@PostMapping("/signUpProcess")
	public ModelAndView signUpProcess(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, String[] roles ){
		ModelAndView mv = new ModelAndView();
		String password = userForm.getPassword();
		userService.saveUser(userForm,roles);
		securityService.autologin(userForm.getUsername(),password);
		mv.setViewName("redirect:/");
		return mv;
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
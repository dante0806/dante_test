package com.dante.main.user;
 
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dante.main.domain.user.User;
import com.dante.main.security.SecurityService;
import com.dante.main.user.UserService;
 
@Controller
public class UserController {
  @Autowired
  UserService userService;
  
  @Autowired
  private SecurityService securityService;
  
  @RequestMapping(value="/main")
  public String main(){
    return "main";
  }
  
// 로그인 
@RequestMapping("/login")
public ModelAndView ViewLoginPage(Model model, String error, String logout, HttpServletRequest request ){
	ModelAndView mv = new ModelAndView();
	if (logout != null){
		model.addAttribute("logout", "You have been logged out successfully.");
	}
	mv.setViewName("main/member/login");
	return mv;
    
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
    System.out.println("regform!!!!!");
    return "main/member/signUp";
  }
  
  // 회원가입 처리 후 로그인 
  @RequestMapping(value="/registration",method=RequestMethod.POST)
  public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, 
          Model model ,String[] roles ){
	  System.out.println("0");
    String password = userForm.getPassword();
    System.out.println("1");
    userService.saveUser(userForm,roles);
    System.out.println("2");
    securityService.autologin(userForm.getUsername(),password);
    System.out.println("3");
    
   // return "redirect:/index";
    return "redirect:/index";
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
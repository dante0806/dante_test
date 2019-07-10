package com.dante.main.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dante.main.domain.member.Member;
import com.dante.main.member.MemberService;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String logingId) throws UsernameNotFoundException{
		
		Member member = memberService.getLogingId(logingId);
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		User user = new User(member.getLogingId(), member.getPassword(), grantedAuthorities);
		
		return user;
	}
}

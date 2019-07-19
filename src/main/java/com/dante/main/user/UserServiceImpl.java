/*package com.dante.main.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dante.main.domain.user.UserRole;
import com.dante.main.domain.user.User;
import com.dante.main.domain.user.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public Long save(MemberDto dto){
		return memberRepository.save(dto.toEntity()).getMem_seq();
	}
	
	public Member getLogingId(String logingId){
		return memberRepository.getOne(logingId);
	}

	@Override
	public void saveUser(User user, String[] roles) {
		user.setUser_pw(bCryptPasswordEncoder.encode(user.getUser_pw()));
		Set<UserRole> rolesSet = new HashSet<UserRole>();
		for(String role:roles){
			rolesSet.add(new UserRole(role));
		}
		user.setUserRoles(rolesSet);
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
*/
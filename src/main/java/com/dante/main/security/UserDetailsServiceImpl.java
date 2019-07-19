package com.dante.main.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dante.main.domain.user.UserRole;
import com.dante.main.domain.user.User;
import com.dante.main.domain.user.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /* UserDetailsService 인터페이스를 상속 받아야함.... 왜 멍청하게 난 저걸 Bean 으로 등록하고 사용하려고 했는지... */
    @Autowired
    UserRepository userRepository; /* 그냥 여긴 JPA DB 쿼리 날려서 가져옴. */

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("username >> " +username);
        User user = userRepository.findByUsername(username); /* JPA row user data */

     

        /* 그냥 String 으로 security User 를 상속한 도메인 객체에 때려박음... 맞는지는 모르겠음 */
        return new UserDetailsImpl(user.getUsername(), user.getPassword(), user.getUserRole().toString());

    }
}
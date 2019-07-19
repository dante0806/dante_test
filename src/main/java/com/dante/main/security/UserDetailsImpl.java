package com.dante.main.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User{
	
	/*public UserDetails(String user_id, String user_pw, Collection<? extends GrantedAuthority> authorities) {
		super(user_id, user_pw, authorities);
	}

	public UserDetails(String user_id, String user_pw, boolean enabled, boolean accountNonExpired,
		boolean credentialsNonExpired, boolean accountNonLocked,
		Collection<? extends GrantedAuthority> authorities) {
		super(user_id, user_pw, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}*/

    /* 사실 여기선 이거밖에 안씀.*/
	public UserDetailsImpl (String user_id, String user_pw, String s) {
		super(user_id, user_pw, AuthorityUtils.createAuthorityList(s));
	}
		
}

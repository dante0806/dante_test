package com.dante.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
  
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
  
	//스프링부트 2.0 이상부터는 AuthenticationManager 를 Bean 으로 재정의 해줘야함.
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		// h2 console 사용을 위한 설정 
		http.csrf().ignoringAntMatchers("/h2-console/**");
		http.headers().frameOptions().sameOrigin();
		http
			.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
            .passwordParameter("password")  
            .successHandler(new CustomAuthenticationSuccess()) // 로그인 성공 핸들러 
            .loginProcessingUrl("/loginProcess")
            .failureHandler(new CustomAuthenticationFailure()) // 로그인 실패 핸들러 
        .and()
	        .logout()
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/")
        .and()
			.authorizeRequests()
			.anyRequest()
			.permitAll()//.authenticated()
			// 해당 url을 허용한다. 
		//	.antMatchers(/*"/resources/**","/loginError","/registration","/h2-console/**",*/ "/**").permitAll();
			.antMatchers("/**").permitAll();
			// admin 폴더에 경우 admin 권한이 있는 사용자에게만 허용 
		//	.antMatchers("/main/**").hasAuthority("ADMIN")
			// user 폴더에 경우 user 권한이 있는 사용자에게만 허용
		//	.antMatchers("/user/**").hasAuthority("USER")
		//	.permitAll()
		//	.permitAll()
		//..and()
			//.exceptionHandling().accessDeniedPage("/403"); // 권한이 없을경우 해당 url로 이동
	}
  
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}  
}


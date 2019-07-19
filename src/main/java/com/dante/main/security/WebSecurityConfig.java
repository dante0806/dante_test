package com.dante.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
  
	@Autowired
	PasswordEncoder passwordEncoder;
		
	/* Password Encoder 등록 */
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}	
  
	/* 인증방식 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	/* Security 제외 패턴 */
	@Override
	public void configure(WebSecurity web) throws Exception {
	web.ignoring()
	.antMatchers("/resources/**");
	}
	
	//스프링부트 2.0 이상부터는 AuthenticationManager 를 Bean 으로 재정의 해줘야함.
	/*@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}*/
	
	/* 각종 시큐어 패턴등록 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		// h2 console 사용을 위한 설정
		http.headers().frameOptions().sameOrigin();
		http
			.authorizeRequests()
			.antMatchers("/resources/**","/loginError","/registration","/loginProcess","/h2-console/**").permitAll()
			// 해당 url을 허용한다. 
			// admin 폴더에 경우 admin 권한이 있는 사용자에게만 허용 
			.antMatchers("/**").hasRole("ADMIN")
			// user 폴더에 경우 user 권한이 있는 사용자에게만 허용
			//	.antMatchers("/user/**").hasAuthority("USER")
			.anyRequest()
			.authenticated()
		.and()	
			.csrf()
	        .ignoringAntMatchers("/h2-console/**")
        .and()
			.formLogin()
			.loginPage("/login")
			/*.usernameParameter("user_id")
            .passwordParameter("user_pw")*/  
			.loginProcessingUrl("/loginProcess")
			.successHandler(new CustomAuthenticationSuccess()) // 로그인 성공 핸들러 
       //  .successHandler(successHandler())
            .failureHandler(new CustomAuthenticationFailure()) // 로그인 실패 핸들러 
            .permitAll()
        .and()
	        .logout()
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/")
	        .permitAll();
	//	.and()
	//		.exceptionHandling().accessDeniedPage("/403"); // 권한이 없을경우 해당 url로 이동
	}
  
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}*/
}


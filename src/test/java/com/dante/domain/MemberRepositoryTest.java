package com.dante.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dante.main.domain.user.User;
import com.dante.main.domain.user.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@After
	public void cleanup(){
		/** 
        이후 테스트 코드에 영향을 끼치지 않기 위해 
        테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
        **/
        userRepository.deleteAll();
	}
	
	@Test
	public void test_reg_mem(){
		//given
		userRepository.save(User.builder()
				.username("dante0806")
				.build());
		
		//when
		List<User> userList = userRepository.findAll();
		
		//then
		User user = userList.get(0);
		assertThat(user.getUsername(), is("dante0806"));
	}
	
}

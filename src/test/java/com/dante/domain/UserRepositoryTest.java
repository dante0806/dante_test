/*package com.dante.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dante.main.domain.user.User;
import com.dante.main.domain.user.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void JPA로_MySql_접근() {
        //given
        userRepository.save(User.builder()
                .user_id("testUser")
                .user_pw("password")
                .use_yn("Y")
                .build());

        //when
        List<User> users = userRepository.findAll();

        //then
        assertTrue(users.stream().anyMatch(user -> user.getUser_id().equals("testUser")));
    }
}*/

package com.dante.main.domain.user;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.dante.main.domain.user.User;
 
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
}

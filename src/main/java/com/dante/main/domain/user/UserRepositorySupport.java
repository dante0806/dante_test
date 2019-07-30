package com.dante.main.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport{

	private final JPAQueryFactory queryFactory;
	
	public UserRepositorySupport(JPAQueryFactory queryFactory){
		super(User.class);
		this.queryFactory = queryFactory;
	}
	
	public List<User> findByName(String username){
		return queryFactory
					.selectFrom(user)
					.where(user.user_id.eq(username))
					.fetch();
	}
}

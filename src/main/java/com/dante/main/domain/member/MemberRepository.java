package com.dante.main.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String>{
	public Member findByUsername(String username);
}

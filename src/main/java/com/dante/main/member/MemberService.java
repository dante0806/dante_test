package com.dante.main.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dante.main.domain.member.Member;
import com.dante.main.domain.member.MemberDto;
import com.dante.main.domain.member.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Transactional
	public Long save(MemberDto dto){
		return memberRepository.save(dto.toEntity()).getMem_seq();
	}
	
	public Member getLogingId(String logingId){
		return memberRepository.getOne(logingId);
	}
}

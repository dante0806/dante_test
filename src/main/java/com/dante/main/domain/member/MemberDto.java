package com.dante.main.domain.member;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

	private String mem_id;
	private String mem_pw;
	private String mem_phone;
	private String mem_zip;
	private String mem_type;
	private String mem_auth1;
	private String mem_auth2;
	private String mem_auth3;
	private String mem_img;
	private String use_yn;
	private Date reg_dt;
	private Date end_dt;
	private Date access_dt;
	
	public Member toEntity(){
		return Member.builder()
				.mem_id(mem_id)
				.mem_pw(mem_pw)
				.mem_phone(mem_phone)
				.mem_zip(mem_zip)
				.mem_type(mem_type)
				.mem_auth1(mem_auth1)
				.mem_auth2(mem_auth2)
				.mem_auth3(mem_auth3)
				.mem_img(mem_img)
				.use_yn(use_yn)
				.reg_dt(reg_dt)
				.end_dt(end_dt)
				.access_dt(access_dt)
				.build();
	}
}

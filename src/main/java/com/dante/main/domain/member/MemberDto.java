package com.dante.main.domain.member;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

	private String mem_id;
	private String mem_pw;
	private String mem_nm;
	private String mem_phone;
	private String mem_zip;
	private String mem_addr;
	private String mem_type;
	private String mem_auth1;
	private String mem_auth2;
	private String mem_auth3;
	private String mem_img;
	private String use_yn;
	private Date access_dt;
	
	@Builder
	public MemberDto(String mem_id, String mem_pw, String mem_nm, String mem_phone, String mem_zip, String mem_addr, String mem_type, 
							 String mem_auth1, String mem_auth2, String mem_auth3, String mem_img, String use_yn, Date access_dt){
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_nm = mem_nm;
		this.mem_phone = mem_phone;
		this.mem_zip = mem_zip;
		this.mem_addr = mem_addr;
		this.mem_type = mem_type;
		this.mem_auth1 = mem_auth1;
		this.mem_auth2 = mem_auth2;
		this.mem_auth3 = mem_auth3;
		this.mem_img = mem_img;
		this.use_yn = use_yn;
	}
	
	public Member toEntity(){
		System.out.println("asdads11");
		return Member.builder()
				.mem_id(mem_id)
				.mem_pw(mem_pw)
				.mem_nm(mem_nm)
				.mem_phone(mem_phone)
				.mem_zip(mem_zip)
				.mem_addr(mem_addr)
				.mem_type(mem_type)
				.mem_auth1(mem_auth1)
				.mem_auth2(mem_auth2)
				.mem_auth3(mem_auth3)
				.mem_img(mem_img)
				.use_yn(use_yn)
				.build();
	}
}

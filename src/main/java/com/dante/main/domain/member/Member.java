package com.dante.main.domain.member;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dante.main.domain.common.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) 
@Getter
@Entity
public class Member extends BaseTimeEntity{

	@Id
	@Column(nullable=false)
	private String logingId;
	
	@GeneratedValue
	@Column(nullable=false)
	private Long mem_seq;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String mem_nm;
	
	private String mem_phone;
	
	private String mem_zip;
		
	private String mem_addr;
	
	@Column(nullable=false)
	private String mem_type;
	
	@Column(nullable=false)
	private String mem_auth1;
	
	private String mem_auth2;
	
	private String mem_auth3;
	
	private String mem_img;
	
	@Column(nullable=false)
	private String use_yn;
	
	private Date access_dt;
	
	@Builder
	public Member(String logingId, String username, String password, String mem_nm, String mem_phone, String mem_zip, String mem_addr, String mem_type, 
							 String mem_auth1, String mem_auth2, String mem_auth3, String mem_img, String use_yn, Date access_dt){
		this.logingId = logingId;
		this.username = username;
		this.password = password;
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
		this.access_dt = access_dt;
		
	}
	
}

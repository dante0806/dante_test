package com.dante.main.domain.member;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

	@Id
	@GeneratedValue
	@Column(length = 10, nullable=false)
	private Long mem_seq;
	
	@Column(length = 50, nullable=false)
	private String mem_id;
	
	@Column(length = 150, nullable=false)
	private String mem_pw;
	
	@Column(length = 50, nullable=false)
	private String mem_nm;
	
	@Column(length = 20, nullable=false)
	private String mem_phone;
	
	@Column(length = 8)
	private String mem_zip;
	
	@Column(length = 200)	
	private String mem_addr;
	
	@Column(length = 10, nullable=false)
	private String mem_type;
	
	@Column(length = 10, nullable=false)
	private String mem_auth1;
	
	@Column(length = 10)
	private String mem_auth2;
	
	@Column(length = 10)
	private String mem_auth3;
	
	@Column(length = 200)
	private String mem_img;
	
	@Column(length = 1, nullable=false)
	private String use_yn;
	
	private Date reg_dt;
	
	private Date end_dt;
	
	private Date access_dt;
	
	@Builder
	public Member(String mem_id, String mem_pw, String mem_nm, String mem_phone, String mem_zip, String mem_addr, String mem_type, 
							 String mem_auth1, String mem_auth2, String mem_auth3, String mem_img, String use_yn, 
							 Date reg_dt, Date end_dt, Date access_dt){
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
		this.reg_dt = reg_dt;
		this.end_dt = end_dt;
		this.access_dt = access_dt;
		
	}
	
}

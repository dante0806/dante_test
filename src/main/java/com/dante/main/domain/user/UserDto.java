/*package com.dante.main.domain.user; 

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	
	private String user_id;
	private String user_pw;
	private String user_nm;
	private String user_phone;
	private String user_zip;
	private String user_addr;
	private String user_img;
	private String use_yn;
	private Date access_dt;
	
	@Builder
	public UserDto(String user_id, String user_pw, String user_nm, String user_phone, String user_zip, String user_addr, 
								  String user_img, String use_yn, Date access_dt){
		
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nm = user_nm;
		this.user_phone = user_phone;
		this.user_zip = user_zip;
		this.user_addr = user_addr;
		this.user_img = user_img;
		this.use_yn = use_yn;
	}
	
	public User toEntity(){
		
		return User.builder()
				.user_id(user_id)
				.user_pw(user_pw)
				.user_nm(user_nm)
				.user_phone(user_phone)
				.user_zip(user_zip)
				.user_addr(user_addr)
				.user_img(user_img)
				.use_yn(use_yn)
				.build();
	}
}
*/
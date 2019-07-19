package com.dante.main.domain.user;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dante.main.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter 
@Setter
@Component
public class User extends BaseTimeEntity{

	@Id
	@Column(nullable=false, name="user_id")
	private String username;
	
	@Column(nullable=false, name="user_pw")
	private String password;
	
	@Column(nullable=false)
	private String user_nm;
	
	private String user_phone;
	
	private String user_zip;
		
	private String user_addr;
	
	private String user_img;
	
	@Column(nullable=false)
	private String use_yn;
	
	private Date access_dt;
	
	
	@OneToMany(targetEntity = UserRole.class, cascade = CascadeType.ALL)
	@JoinColumn(name="user_role_user_id")
	private Set<UserRole> userRole = new HashSet<>();
	
}

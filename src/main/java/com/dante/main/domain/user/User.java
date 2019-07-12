package com.dante.main.domain.user;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.dante.main.domain.common.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
public class User extends BaseTimeEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
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
	
	@Builder
	public User(Long id, String username, String password, String user_nm, String user_phone, String user_zip, String user_addr, 
							 String user_img, String use_yn, Date access_dt){
		this.id = id;
		this.username = username;
		this.password = password;
		this.user_nm = user_nm;
		this.user_phone = user_phone;
		this.user_zip = user_zip;
		this.user_addr = user_addr;
		this.user_img = user_img;
		this.use_yn = use_yn;
		this.access_dt = access_dt;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_role",
				joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles;
	
}

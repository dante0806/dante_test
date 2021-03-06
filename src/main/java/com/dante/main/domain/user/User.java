package com.dante.main.domain.user;

import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.dante.main.domain.common.BaseTimeEntity;

import lombok.Data;
import lombok.Getter;
 
@Getter
@Entity
@Data
@Table(name = "user")
public class User extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_id")
	private String username;
	
	@Column(name="user_pw")
	private String password;
	
	private String user_nm;
	private String user_zip;
	private String user_addr;
	private String user_phone;
	private String use_yn;
	
  
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
					   inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<UserRole> roles;
	
	/*@OneToMany(mappedBy = "user") //Board 객체와 양방향 관계를 만들기 위해 추가(대상테이블) 
	private List<Board> board = new ArrayList<Board>();*/
}
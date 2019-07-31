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
 
import lombok.Data;
 
@Entity
@Table(name = "user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}
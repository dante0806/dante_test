package com.dante.main.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name="user_role")
@Data
@Component
public class UserRole {
	
	@Id
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="role")
	private String role;
	
	public enum Role{
		ROLE_ADMIN
	}
}

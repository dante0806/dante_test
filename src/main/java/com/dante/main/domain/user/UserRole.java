package com.dante.main.domain.user;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
import lombok.Data;
 
@Entity
@Table(name="role")
@Data
public class UserRole {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	 
	public UserRole(){
	}
	  
	public UserRole(String name){
		this.name = name;
	}
}
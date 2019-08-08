package com.dante.main.domain.photo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name="album")
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="album_id")
	private Long id ;
	
	private String album_name;
	
	private String reg_id;	
	
	@Builder
	public Album(String album_name, String reg_id){
		this.album_name = album_name;
		this.reg_id = reg_id;
	}
}

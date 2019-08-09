package com.dante.main.domain.photo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.dante.main.domain.common.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name="photo")
public class Photo extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long photo_id;
	
	private Long album_id;
	
	private String photo_title;
	
	private String photo_content;
	
	private Long file_id;
	
	private String reg_id;
	
	@ManyToOne
	@JoinColumn(name="photo_album_id", referencedColumnName="album_id")
	private Album album;
	
	
	@Builder
	public Photo(Long album_id, String photo_title, String photo_content, Long file_id, String reg_id){
		this.album_id = album_id;
		this.photo_title = photo_title;
		this.photo_content = photo_content;
		this.file_id = file_id;
		this.reg_id = reg_id;
	}
	
}

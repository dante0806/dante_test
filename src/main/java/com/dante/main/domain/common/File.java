package com.dante.main.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Table(name="file")
@Data
public class File extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="file_id")
	private Long id;
	
	private String file_name;
	
	private Long file_size;
	
	private String file_type;
	
	@Lob
	private byte[] data;
	
	@Builder
	public File (String file_name, Long file_size, String file_type, byte[] data){
		this.file_name = file_name;
		this.file_size = file_size;
		this.file_type = file_type;
		this.data = data;
	}
}

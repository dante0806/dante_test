package com.dante.main.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="board")
@Data
public class Board {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length= 500, nullable = false)
	private String board_title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String board_content;
	
	private String user_id;
	
	@Builder
	public Board(String board_title, String board_content, String user_id){
		this.board_title = board_title;
		this.board_content = board_content;
		this.user_id = user_id;
	}
	
	/*@ManyToOne
	@JoinColumn(name="user_user_id") //조인컬럼은 외래키를 매핑할때 사용(연관관계주인)
	private User user;	//연관관계 주인필드*/
	
}

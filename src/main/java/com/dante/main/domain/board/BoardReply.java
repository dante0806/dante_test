package com.dante.main.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.dante.main.domain.common.BaseTimeEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="board_reply")
@Data
public class BoardReply extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long board_id;
	
	@Lob
	@Column(columnDefinition = "TEXT", nullable = false)
	private String board_reply_content;
	
	private String user_id;
	
	@Builder
	public BoardReply(Long board_id, String board_reply_content, String user_id){
		this.board_id = board_id;
		this.board_reply_content = board_reply_content;
		this.user_id = user_id;
	}
	
	/*@ManyToOne
	@JoinColumn(name="user_user_id") //조인컬럼은 외래키를 매핑할때 사용(연관관계주인)
	private User user;	//연관관계 주인필드*/
	
}

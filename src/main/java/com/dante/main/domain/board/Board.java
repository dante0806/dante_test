package com.dante.main.domain.board;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dante.main.domain.user.User;

import lombok.Data;

@Entity
@Table(name="board")
@Data
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_id;
	
	private String board_title;
	private String board_content;
	private String user_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}

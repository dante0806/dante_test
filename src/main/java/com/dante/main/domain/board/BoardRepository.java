package com.dante.main.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dante.main.domain.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{	
}

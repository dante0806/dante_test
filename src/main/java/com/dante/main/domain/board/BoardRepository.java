package com.dante.main.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dante.main.domain.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	@Modifying	// update, delete query에 사용
	@Query(value="UPDATE Board b "+		//domain명과 같게 세팅해줘야해서 테이블명 board 가 아니라 도메인명 Board !! 
							"   	SET b.board_title = :#{#boardForm.board_title}, "+
							"			   b.board_content = :#{#boardForm.board_content}"+
							"		WHERE b.id = :#{#boardForm.board_id} ", nativeQuery=false)
	Integer update(Board board);
}

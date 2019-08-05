package com.dante.main.domain.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dante.main.domain.board.Board;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>{
	
	@Modifying	// update, delete query에 사용
	@Query(value="SELECT b FROM BoardReply b WHERE b.board_id = :board_id ORDER BY b.reg_dt DESC ", nativeQuery=false)
	List<BoardReply> getBoardReplyList(@Param("board_id") Long board_id);
	
	@Modifying	// update, delete query에 사용
	@Query(value="DELETE FROM BoardReply b WHERE b.board_id = :board_id ", nativeQuery=false)
	Integer delBoardReplyByBoard_id(@Param("board_id") Long board_id);
	
}

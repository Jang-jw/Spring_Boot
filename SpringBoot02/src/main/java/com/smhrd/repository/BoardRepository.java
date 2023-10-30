package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	
}

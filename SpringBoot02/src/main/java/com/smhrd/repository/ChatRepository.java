package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{
	
	
}

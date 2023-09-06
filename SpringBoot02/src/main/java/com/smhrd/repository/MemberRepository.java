package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
	
	// JPA 의 DAO (Repository) 는 interface 로 구현
	// JpaRepository interface 를 상속 받음 
	// extends JpaRespository<Table 역할의 DTO, primary 의 자료형>
	
	// JPA : NO SQL
	// 기본적으로 사용자들이 많이 사용하는 기능들을 미리 정의해둔 interface 를 상속 받아 사용 
	// => 우리가 코딩을 하지 않아도 기본적인 메소드들을 사용할 수 있다. 
	
	// findAll() : select * from member; 
	// findByID(String id) : select * from member where email = #{email};
	
	// save(Member member) : insert, update
	// member.email 이 DB 에 존재한다면, update
	// 없다면, insert 
	
	// 로그인 : select * from member where email = #{email} adn pw = #{pw} 
	// 우리가 직접 메소드 만들기 
	public Member findByEmailAndPw(String email, String pw);
	// 메소드의 이름을 기반으로 SQL 문을 생성 
	// 카멜 기법으로만 만들어야 함
	// By 절에 있는 컬럼의 이름이 잘 일치해야 한다. 
	
	// @Query("SQL 문") // 한줄로 적어야 한다. 
	// public Member ~~~();

}

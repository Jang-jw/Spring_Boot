package com.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.smhrd.entity.Chat;
import com.smhrd.repository.ChatRepository;

@Service // Controller 와 유사, 기능을 정의해놓고 불러다가 사용만 하는 경우 
@ServerEndpoint("/chat") // URLMapping, chat 으로 끝나는 요청을 받겠다. 
public class WebSocketController {
	
	@Autowired
	private ChatRepository repo;
	
	// 사용자의 연결 정보를 저장할 list 
	private static List<Session> sessionList = new ArrayList<Session>();
	// 각 이벤트 발생시 무슨일이 일어날 것인가를 정의 
	
	// 1. 사용자가 웹 소켓에 연결 되었을 때
	@OnOpen
	public String onOpen(Session session) {
		
		System.out.println("사용자 연결 됨~~~");
		
		sessionList.add(session);
		
		return "안녕~";
	}
	
	// 2. (사용자가 보낸) 메세지가 도착했을 때
	@OnMessage
	public void onMessage(Session session, String msg) {
		
		// JSON => Java (Gson) 
		// Gson 라이브러리로 받아온 JSON 을 Java 객체로 변환하기 
		Gson gson = new Gson();
		
		Chat chat = gson.fromJson(msg, Chat.class);
		
		// DB 에 chat 을 저장 
		repo.save(chat);
		
		// 보낸 사람을 제외한 나머지 사용자들에게 MSG 를 뿌려주기 
		for (Session s : sessionList) {
			
			if (!s.equals(session)) {
				
				try {
					
					// 사용자에게 msg 뿌리기 ( 받은 json 을 그대로 전달) 
					s.getBasicRemote().sendText(msg);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	// 3. 사용자가 연결을 해제했을 때
	@OnClose
	public void onClose(Session session) {
		
		int idx = 0;
		for (Session s : sessionList) {
			
			if (s.equals(session)) {
				
				break;
			}
			
			idx++;
		}
		
		// 해당 사용자의 session 을 list 에서 삭제 
		sessionList.remove(idx);
	}
	
	// 4. 에러 생겼을 때 

}

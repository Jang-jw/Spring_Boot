package com.smhrd.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Component // 메모리에 등록 시키겠다. 
public class WebSocketConfig {
	
	// ServerEndPoint 에 대한 처리를 어떻게 할 것인지 Bean 으로 등록해둬야함
	// <bean id="serverEndpointExporter" class="ServerEndpointExporter"></bean>
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		
		return new ServerEndpointExporter();
	}

}

package com.el.chat.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler {
  private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
  
  // 클라이언트와 연결 이후에 실행되는 메서드
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    sessionList.add(session);
    System.out.println("클라이언트가 연결됨!");
  }
  
  // 클라이언트가 서버로 메시지를 전송했을 때 실행되는 메서드
  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    System.out.println("클라이언트로부터 받은 메시지: " + message.getPayload());
    for (WebSocketSession session2 : sessionList) {
      session2.sendMessage(new TextMessage("서버에서 되돌리는 메시지: " + message.getPayload()));
    }
  }
  
  // 클라이언트와 연결을 끊었을 때 실행되는 메소드
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    sessionList.remove(session);
    System.out.println("클라이언트가 연결을 끊음!");
  }
  
  
  
}

package com.el.chat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.el.chat.domain.Member;
import com.el.chat.service.ChatService;

@Controller
@RequestMapping
public class ChatController {
  @Autowired
  ChatService chatService;
  
  @GetMapping("chat")
  public void chat() {}
  
  public String chat (Model model, HttpServletRequest request) throws Exception {
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      return "redirect:login";
    }
    
    return null;
  }
  
}

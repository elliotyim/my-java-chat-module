package com.el.chat.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping
public class TestController {
  
  @PostMapping("test")
  @ResponseBody
  public Object test(MultipartHttpServletRequest request) {
    
    // FormData로 넘긴 텍스트
    System.out.println(request.getParameter("text"));
    
    // FormData로 넘긴 파일
    Iterator<String> iter = request.getFileNames();
    List<MultipartFile> s = request.getFiles(iter.next());
    System.out.println(s.get(0).getOriginalFilename());
    
    // Client로 맵 객체를 하나 리턴
    Map<String, String> map = new HashMap<>();
    map.put("testKey", "testValue");
    
    return map;
  }
}

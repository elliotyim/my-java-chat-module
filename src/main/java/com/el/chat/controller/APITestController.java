package com.el.chat.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class APITestController {
  
  private String getStringFrom(InputStream in) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    StringBuilder sb = new StringBuilder();
    String line;
    
    while ((line = br.readLine()) != null)
      sb.append(line);
    
    return sb.toString();
  }
  
  @PostMapping("api")
  @ResponseBody
  public Object api(@RequestBody String message) throws Exception {
    
    // URL 세팅 및 연결
    URL url = new URL("http://localhost:8888/app/test2");
    HttpURLConnection urlConnection =
        (HttpURLConnection) url.openConnection();
    
    // 시간초과에 대한 설정
    urlConnection.setConnectTimeout(5000);
    urlConnection.setReadTimeout(5000);
    
    // 메소드 타입설정
    urlConnection.setRequestMethod("POST");
    
    // Http 헤더설정
    urlConnection.setRequestProperty("Content-Type", "application/json");
    
    // JSON String 전송
    urlConnection.setDoOutput(true);
    PrintWriter writer = new PrintWriter(
        new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
    writer.write("{\"message\":\"hahaha\"}");
    writer.flush();
    
    // API로 부터 받은 결과값을 JSONObject에 저장
    InputStream in = 
        new BufferedInputStream(urlConnection.getInputStream());
    JSONObject json = new JSONObject(getStringFrom(in));
    
    // 맵 객체 하나를 임의로 생성하여 리턴 (테스트용)
    Map<String, String> map = new HashMap<>();
    map.put("testKey", json.getString("testKey"));
    
    return map;
  }
  
  public void templateAPICode() throws Exception {
    // URL 세팅 및 연결
    URL url = new URL("http://localhost:8888/app/test2");
    HttpURLConnection urlConnection =
        (HttpURLConnection) url.openConnection();
    
    // 메소드 타입설정
    urlConnection.setRequestMethod("POST");
    
    // Http 헤더설정
    urlConnection.setRequestProperty("Content-Type", "application/json");
    
    // JSON String 전송
    urlConnection.setDoOutput(true);
    PrintWriter writer = new PrintWriter(
        new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
    writer.write("{\"message\":\"hahaha\"}");
    writer.flush();
    
    // API로 부터 받은 결과값을 JSONObject에 저장
    InputStream in = 
        new BufferedInputStream(urlConnection.getInputStream());
    JSONObject json = new JSONObject(getStringFrom(in));
    
    System.out.println("Result JSON: " + json.getString("test"));
  }
  
}

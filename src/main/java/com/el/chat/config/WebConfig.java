package com.el.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.el.chat")
@EnableWebMvc
public class WebConfig {
  
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver vr =
        new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
    vr.setOrder(1);
    return vr;
  }
  
  @Bean
  public MultipartResolver multipartResolver() {
    CommonsMultipartResolver mr = new CommonsMultipartResolver();
    mr.setMaxUploadSize(10000000);
    mr.setMaxInMemorySize(2000000);
    mr.setMaxUploadSizePerFile(5000000);
    return mr;
  }
}

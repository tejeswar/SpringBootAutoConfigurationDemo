package com.example.demo.lifecycle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ServletConfig {

  

  @Autowired
  DispatcherServlet servlet;

  @PostConstruct
  public void init() {
    // Normal mode
  servlet.getServletConfig();
  }
}

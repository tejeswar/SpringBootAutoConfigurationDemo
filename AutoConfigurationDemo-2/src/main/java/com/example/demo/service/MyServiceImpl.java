package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.configuration.HelloServiceInfc;

@Component
public class MyServiceImpl implements HelloServiceInfc{

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("Hello from MyBean= this is my own defined value");
	}

}

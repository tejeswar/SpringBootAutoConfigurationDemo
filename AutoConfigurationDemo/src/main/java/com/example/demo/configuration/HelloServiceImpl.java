package com.example.demo.configuration;

public class HelloServiceImpl implements HelloServiceInfc{

	
	public HelloServiceImpl() {
		System.out.println(" Constructor   HelloServiceImpl");
	}
	@Override
	public void hello() {
		System.out.println("Hello from the default starter");
		
	}

}

package com.example.demo.configuration;

//@Component
public class HelloServiceOurBean implements HelloServiceInfc{

	public HelloServiceOurBean() {
		System.out.println("Our default HelloServiceOurBean constructore");
	}
	@Override
	public void hello() {
		System.out.println("We are doing hello...");
		
	}

}

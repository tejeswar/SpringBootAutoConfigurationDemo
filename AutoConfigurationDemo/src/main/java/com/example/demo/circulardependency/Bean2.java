package com.example.demo.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Bean2 {
	@Autowired
	private Bean3 bean1;
	
//	public Bean2() {
//		System.out.println("default Bean2 constructor");
//	}
	//public Bean2( Bean3 bean11) {
	public Bean2(@Lazy Bean3 bean11) {
		System.out.println("Bean2 constructor");
		bean1 = bean11;
	}

	public Bean3 getBean1() {
		return bean1;
	}

	public void setBean1(Bean3 bean1) {
		this.bean1 = bean1;
		System.out.println("adding the bean for that purpose...");
	}
	
	
}

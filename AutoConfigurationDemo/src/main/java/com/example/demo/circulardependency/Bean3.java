package com.example.demo.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Bean3 {

@Autowired
private Bean2 bean2; 

//public Bean3() {
//	
//}
public Bean3( Bean2 bean22) {
//public Bean3(@Lazy Bean2 bean22) {
	System.out.println("Bean3 constructor");
	bean2 = bean22;
}
public void doSomeThing()
{
	System.out.println("Bean1 Doing some work");
}
public Bean2 getBean2() {
	return bean2;
}
public void setBean2(Bean2 bean2) {
	this.bean2 = bean2;
}



}

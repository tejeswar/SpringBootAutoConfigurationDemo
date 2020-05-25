package com.example.demo.requestscope;

public class PrototypeScopedBean {

	public PrototypeScopedBean() {
		System.out.println("PrototypeScopedBean Constructore got called...");
	}
	
	public void printMsg() {
		System.out.println("This is PROTOTYPE_SCOPED_BEAN");
	}
}

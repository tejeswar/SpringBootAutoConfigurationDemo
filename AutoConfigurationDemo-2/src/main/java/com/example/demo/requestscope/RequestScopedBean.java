package com.example.demo.requestscope;


public class RequestScopedBean {
	
	public RequestScopedBean() {
		System.out.println("Constructore got called...");
	}
	
	public void printMsg() {
		System.out.println("This is REQUEST_SCOPED_BEAN");
	}

}

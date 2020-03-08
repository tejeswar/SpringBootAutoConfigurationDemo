package com.example.demo.configuration;
//https://www.youtube.com/watch?v=d7gryigdpIs

//https://www.youtube.com/watch?v=UVfJY-EOs00 step by step must watch
//https://www.youtube.com/watch?v=sjMe9aecW_A // with spring
public class LocalThreadDemo {

	public static void main(String[] args) {
		SharedUtil util = new SharedUtil();
		
		Thread t1 = new Thread(() -> {
			util.setTableFor(3);
			util.printMultiplicationTable();
		});
	//	t1.setName("Sipu ");
		
		Thread t2 = new Thread(() -> {
			util.setTableFor(8);
			util.printMultiplicationTable();
		});
		//t1.setName("Spoorthy ");
		
		t1.start();
		t2.start();
	}
}

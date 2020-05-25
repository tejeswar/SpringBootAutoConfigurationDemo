package com.example.demo.sessionscope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RandomizerRequestScope {
	private int randomNumber = 5;
	
	public int getRandomNumber() {
		return randomNumber;
	}
	
	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 99999);
	}
}

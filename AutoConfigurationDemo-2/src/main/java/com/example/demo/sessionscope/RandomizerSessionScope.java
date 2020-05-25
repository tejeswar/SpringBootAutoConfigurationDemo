package com.example.demo.sessionscope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RandomizerSessionScope {
	private int randomNumber = 10;
	
	public int getRandomNumber() {
		return randomNumber;
	}
	
	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 99999);
	}
}

package com.example.demo.requestscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondService {
	
	@Autowired
	private RequestScopedBean requestScopedBean;
	@Autowired
	private PrototypeScopedBean PrototypeScopedBean;
	
	public void printSecondMsg() {
		requestScopedBean.printMsg();	
		PrototypeScopedBean.printMsg();
	}

}

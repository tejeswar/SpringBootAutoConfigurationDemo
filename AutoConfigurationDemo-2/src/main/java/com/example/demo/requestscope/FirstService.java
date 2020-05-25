package com.example.demo.requestscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {
	
	@Autowired
	private RequestScopedBean requestScopedBean;
	
	@Autowired
	private PrototypeScopedBean PrototypeScopedBean;
	
	@Autowired
	private SecondService secondService;
	
	public void printFirstMsg() {
		
		requestScopedBean.printMsg();
		secondService.printSecondMsg();
		
		PrototypeScopedBean.printMsg();
		
	}
	

}

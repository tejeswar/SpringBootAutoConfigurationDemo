package com.example.demo.requestscope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class ApplConfiguration {
	
	@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	@Bean()
	public RequestScopedBean getRequestScopedBean() {
		return new RequestScopedBean();
	}
	
	@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
	@Bean()
	public PrototypeScopedBean getPrototypeScopedBean() {
		return new PrototypeScopedBean();
	}

}

package com.example.demo.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class Employee implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware{
  
	private String name;
	
	public Employee() {
		System.out.println("Employee default constructor");
	}
    @PostConstruct
    public void init1() {
    	System.out.println("Inside postConstruct method");
    }
    @PreDestroy
    public void destroy1() {
    	System.out.println("Inside @PreDestroy method");
    }
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory");
		
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		
	}
	public void customInit() {
		System.out.println("customInit method");
	}
	
	public void customDestroy() {
		System.out.println("customDestroy method");
	}
	
public void fixingBugCode() {
	System.out.println("this code will fix the bug ");
}
	
	
    
	
	
}

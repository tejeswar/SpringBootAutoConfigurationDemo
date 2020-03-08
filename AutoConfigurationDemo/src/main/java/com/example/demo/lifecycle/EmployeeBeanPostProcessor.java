package com.example.demo.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EmployeeBeanPostProcessor implements BeanPostProcessor{
	
	public EmployeeBeanPostProcessor() {
		System.out.println("EmployeeBeanPostProcessor constructor got called ");
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException 
    {
        System.out.println("Called postProcessBeforeInitialization() for :" + beanName);
        return bean;
    }
     
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException 
    {
        System.out.println("Called postProcessAfterInitialization() for :" + beanName);
        return bean;
    }
}

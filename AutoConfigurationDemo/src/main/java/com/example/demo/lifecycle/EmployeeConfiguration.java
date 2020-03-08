package com.example.demo.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {

	//@Bean
	@Bean(initMethod = "customInit",destroyMethod = "customDestroy",name= {"employeeBean"})
	//@Bean(initMethod = "customInit",destroyMethod = "customDestroy",name= {"employeeBean","helloBean"})
	public Employee getEmployee() {
		System.out.println("this code is related to fix only...");
		Employee e1 = new Employee();
		return e1;
		
	}
	@Bean
	public EmployeeBeanPostProcessor getBeanPostProcessor() {
		EmployeeBeanPostProcessor ebpp = new EmployeeBeanPostProcessor();
		return ebpp;
	}
}

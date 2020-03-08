package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.configuration.HelloServiceInfc;
import com.example.demo.service.MyServiceImpl;
//https://www.youtube.com/watch?v=mi0GfmTv2wg
//https://www.baeldung.com/spring-boot-custom-auto-configuration
//https://www.baeldung.com/spring-boot-custom-starter
@SpringBootApplication
public class AutoConfigurationDemo2Application implements CommandLineRunner {
	
	@Autowired
	HelloServiceInfc helloService123;

	public static void main(String[] args) {
		SpringApplication.run(AutoConfigurationDemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		helloService123.hello();
	}
//	@Bean
//    public HelloServiceInfc helloService() {
//	return new MyServiceImpl();
//}
}

package com.example.demo.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnClass(HelloServiceInfc.class)
public class HelloServiceAutoConfiguration {

	 //conditional bean creation
	/*
	Field hello123 in com.example.demo.Test required a single bean, but 2 were found:
		- helloService: defined by method 'helloService' in class path resource [com/example/demo/configuration/HelloServiceAutoConfiguration.class]
		- helloServiceInfc: defined by method 'helloServiceInfc' in class path resource [com/example/demo/configuration/HelloServiceAutoConfiguration.class]
		
		*/
    @Bean
    @ConditionalOnMissingBean
    //@Primary//put this in order to fix the above commented  issue
    public HelloServiceInfc helloService(){

        return new HelloServiceImpl();
    }
    
//    @Bean
//    public HelloServiceInfc helloServiceInfc(){
//
//        return new HelloServiceOurBean();
//    }
}

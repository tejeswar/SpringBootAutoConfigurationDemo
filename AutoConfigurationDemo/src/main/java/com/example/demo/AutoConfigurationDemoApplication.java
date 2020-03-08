package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//https://github.com/snicoll/hello-service-auto-configuration
//https://sysout.dev/building-custom-spring-boot-auto-configurations-cjxrnej07001c3is15a07xkel
import org.springframework.context.ApplicationContext;

import com.example.demo.circulardependency.Bean3;


//https://docs.spring.io/spring-boot/docs/2.0.0.M5/reference/html/boot-features-developing-auto-configuration.html
//https://www.baeldung.com/spring-boot-custom-auto-configuration


//https://www.baeldung.com/spring-boot-custom-starter  = more clear



//http://prudentstream.com/lc/springboot.html?topicKey=autoconfigure
//https://www.youtube.com/watch?v=FQO2l3i5fRg
//https://www.javadevjournal.com/spring-boot/spring-boot-custom-starter/
//https://www.javadevjournal.com/spring-boot/how-spring-boot-auto-configuration-works/


@SpringBootApplication
public class AutoConfigurationDemoApplication implements CommandLineRunner{

//	@Autowired
//	private Bean1 bean1;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(AutoConfigurationDemoApplication.class, args);
		
		System.out.println("End of AutoConfigurationDemoApplication :");
		//new Test().test();
		
		System.out.println("Hello from java");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//bean1.doSomeThing();
		System.out.println("Just adding the application context for name sake");
		System.out.println("applicationContext : "+applicationContext);
		//System.out.println(applicationContext.getBean("getEmployee"));
		//System.out.println(applicationContext.getBean("helloBean"));
		System.out.println(applicationContext.getBean("employeeBean"));
		
	}

}

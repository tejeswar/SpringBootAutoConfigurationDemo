package com.techprimers.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//https://www.youtube.com/watch?v=uL0xP57negc   for lfu evict policy
//https://deepakvadgama.com/blog/lfu-cache-in-O%281%29/

//https://www.geeksforgeeks.org/least-frequently-used-lfu-cache-implementation/



///https://github.com/TechPrimers/spring-ehcache-example   git hub link from which i downloaded this application
//https://www.youtube.com/watch?v=cWqNeANzEz0&t=162s  = this video only explain about this applications

//https://docs.spring.io/spring/docs/4.1.x/spring-framework-reference/html/cache.html

//https://www.youtube.com/watch?v=qu_wQNFxJxw  //with mysql kk tutorials

//https://www.youtube.com/watch?v=6uWU3gDhZk4  //crud with cache and with spring cache documentation
//https://www.youtube.com/watch?v=ccfQ1j4suN0  // with search plant UI

@EnableJpaRepositories
@SpringBootApplication
public class SpringEhcacheExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEhcacheExampleApplication.class, args);
		System.out.println("main application running....");
	}
}

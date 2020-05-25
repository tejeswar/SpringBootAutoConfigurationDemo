package com.example.demo.requestscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.journaldev.com/21039/spring-bean-scopes  // know about session scope as well


@RestController(value = "/users")
public class RequestScopeController {
	
	@Autowired
	private FirstService firstService;
	
	@GetMapping("/request")
	public ResponseEntity<?> getUsers(){
		System.out.println("Getting all users...");
		firstService.printFirstMsg();
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

}

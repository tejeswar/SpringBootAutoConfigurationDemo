package com.example.demo.controller;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class MyController {
	
	
	
	
	@RequestMapping("/test")
	public String test(@RequestBody(required = false) String hi) {
		System.out.println(hi);
		return "defulat";
		
	}
	
	@RequestMapping(path = "/testCreate",method = RequestMethod.POST)
	public String testCreate() {
		return "defulat";
		
	}
	
	@RequestMapping(path = "/testUpdate/{id}",method = RequestMethod.PUT)
	public String testUpdate(@PathVariable("id1") int empId,@RequestBody Employee employee) {
		System.out.println("Employee with id:"+empId +" is going to be update");
		return "defulat";
		
	}
	
	@RequestMapping(path = "/testDelete",method = RequestMethod.DELETE)
	public String test(@PathVariable("id") int empId,@RequestBody String hi) {
		return "defulat";
		
	}
	
	
   @GetMapping("/")
	public String getMsg() {
		return "Hello world...";
	}
	@PostMapping("/{msg}")
	public String getMessage(@PathVariable("msg") String messg) {
		return "Your msg is:"+messg   ;
	}
	
	@DeleteMapping("/deleteUser/")
   public boolean deleteUser(@RequestParam("id") String id) {
	   System.out.println("User with id : "+id +" got deleted...");
	   return true;
   }
	@PutMapping("/update/{id}")
	public boolean updateUser(@PathVariable("id") int empId,@RequestBody Employee employee) {
		System.out.println("Employee with id:"+empId +" is going to be update");
		System.out.println(employee.getName());
		return true;
	}
}

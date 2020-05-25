package com.techprimers.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.cache.model.Users;
import com.techprimers.cache.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//http://localhost:8080/insertDummyUserRecords
	@RequestMapping(value = "/insertDummyUserRecords", method = RequestMethod.GET)
	public ResponseEntity<?> insertUsers() {
		userService.insertDummyUsers();;
		
		return new ResponseEntity<String>("All user records inserted...", HttpStatus.OK);
	}
	//http://localhost:8080/getAllUsers
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers(){
		
		List<Users> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}
	@PutMapping("/updateUser")
	public ResponseEntity<?>  updateUser(@RequestBody Users user) {
		userService.updateUser(user);
		
		return new ResponseEntity<>("Updated successfully...", HttpStatus.OK);
	}
	//http://localhost:8080/getUser/Ajay
	 @GetMapping(value = "/getUser/{name}")
	    public Users getUser(@PathVariable final String name) {
	        return userService.getUser(name);
	    }
	
}

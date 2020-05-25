package com.example.demo.sessionscope;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ScopeController {
	
	@Autowired
	RandomizerRequestScope randomizerRequestScope;
	
	@Autowired
	RandomizerSessionScope randomizerSessionScope;
	
//	@RequestMapping("/sessionscope")
//	public void getRandom(HttpServletResponse response) throws Exception {
//		response.getWriter().write("**********************  request scope  ********************** <br>");
//		response.getWriter().write("Old number: "+ randomizerRequestScope.getRandomNumber() + "<br>");
//		randomizerRequestScope.generateRandomNumber();
//		response.getWriter().write("New Number: "+ randomizerRequestScope.getRandomNumber() + "<br>");
//		response.getWriter().write("Object reference: " + randomizerRequestScope + "<br>");
//
//		response.getWriter().write("**********************  session scope  ********************** <br>");
//		response.getWriter().write("Old number: "+ randomizerSessionScope.getRandomNumber() + "<br>");
//		randomizerSessionScope.generateRandomNumber();
//		response.getWriter().write("New Number: "+ randomizerSessionScope.getRandomNumber() + "<br>");
//		response.getWriter().write("Object reference: " + randomizerSessionScope + "<br>");
//
//	}
	
	@RequestMapping("/sessionscope1")
	public ResponseEntity<?> getRandom1() throws Exception {
		String s1 = "";
		s1 += "**********************  request scope  ********************** \n";
		s1 += "Old number: "+ randomizerRequestScope.getRandomNumber() + "\n";
		randomizerRequestScope.generateRandomNumber();
		s1 += "New Number: "+ randomizerRequestScope.getRandomNumber() + "\n";
		s1 += "Object reference: " + randomizerRequestScope + "\n";

		s1 += "**********************  session scope  ********************** \n";
		s1 += "Old number: "+ randomizerSessionScope.getRandomNumber() + "\n";
		randomizerSessionScope.generateRandomNumber();
		s1 += "New Number: "+ randomizerSessionScope.getRandomNumber() + "\n";
		s1 += "Object reference: " + randomizerSessionScope + "\n";

		
		return new ResponseEntity<String>(s1,HttpStatus.OK);
	}
}

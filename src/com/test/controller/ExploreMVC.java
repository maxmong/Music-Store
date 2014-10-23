package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExploreMVC {

	  @RequestMapping("/hello")
	    public ModelAndView helloWorld() {
	 
	        String message = "Hello World, Spring 3.0!";
	        System.out.println(message);
	        return new ModelAndView("hello", "message", message);
	    }
	  @RequestMapping("/users")
	  public ModelAndView usersTable(){
		  String message = "welcome to the user controller";
		  System.out.println("this is user controller");
		  return new ModelAndView("users", "message", message);
	  }
}

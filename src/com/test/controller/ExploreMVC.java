package com.test.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.W_basketDao;
import com.test.model.W_basket;

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
	  @RequestMapping("/w_basket")
	  public ModelAndView w_basketTest(){
		  
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml");
		  
		 // W_basket b = new W_basket();
		  //b.setId(24);
		  //b.setType(56);
		 // b.setDescription("fdfdfddddd");
		 // W_basketDao wb = (W_basketDao)ctx.getBean("edao");
		  
		  //int message = wb.saveBasket(b);
		  String message = "just for test";
		  System.out.println("this is user controller");
		  return new ModelAndView("w_basket_test", "message", message);
	  }
}

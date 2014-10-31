package com.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.GenreDao;
import com.test.dao.SeedsDao;
import com.test.model.Genre;

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
		  
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  
		
		  GenreDao gd = (GenreDao)ctx.getBean("edao");
		  List<Genre> count = gd.genreIndex();
		
		  System.out.println("this is user controller");
		  return new ModelAndView("w_basket_test", "message", count);
	  }
	  @RequestMapping("/addSeeds")
	  public ModelAndView addSeeds(){
		  
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  
		  SeedsDao sd = (SeedsDao)ctx.getBean("seedsDao");
		  String seedMsg = sd.addSeeds();
		  
		  return new ModelAndView("hello","message",seedMsg);
	  }
	  @RequestMapping("/resetSeeds")
	  public ModelAndView resetSeeds(){
		  
          ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  
		  SeedsDao sd = (SeedsDao)ctx.getBean("seedsDao");
		  sd.resetSeeds();
		  
		  return new ModelAndView("hello","message","DROP TABLE GENRE SUCCESSFULLY! ");
	  }
	  @RequestMapping("/testTag")
	    public ModelAndView testTag() {
	 
	        String message = "tag";
	        System.out.println(message);
	        return new ModelAndView("testTag", "message", message);
	    }
	  
}

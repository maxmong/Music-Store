package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

	 @RequestMapping("/Store")
	    public ModelAndView Index() {
	 
		 List<String> genre = new ArrayList<String>();
		 genre.add("Jazz");
		 genre.add("Blues");
		 genre.add("POP");
	     System.out.println(genre);
	     return new ModelAndView("store", "message", genre);
	    }
	 
	  @RequestMapping("/Store/Browse")
	  public ModelAndView Browse(){
		  String message = "echo from store.browse";
		  System.out.println("this is user controller");
		  return new ModelAndView("store", "message", message);
	  }
	  @RequestMapping(value="/Store/Browse/{genre}", method=RequestMethod.GET)
	  public ModelAndView findGenre(@PathVariable String genre, Model model){
		  return new ModelAndView("store", "message", genre);
	  }
	  @RequestMapping("/Store/Details")
	  public ModelAndView Details(){
		  String message = "echo from store.details";
		  System.out.println("this is user controller");
		  return new ModelAndView("store", "message", message);
	  }
	  @RequestMapping(value="/Store/Details/{id}", method=RequestMethod.GET)
	  public ModelAndView findDetail(@PathVariable int id, Model model){
		  String message = "Albumn: " + id;
		  return new ModelAndView("store", "message", message);
	  }
}

package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.User;

@Controller
@RequestMapping(value="/login")
public class RegisterController {
	 @RequestMapping(method = RequestMethod.GET)
	   public String viewRegistration(Map<String, Object> model) {
	        User userForm = new User();    
	        model.put("userForm", userForm);
	         
	        List<String> professionList = new ArrayList<String>();
	        professionList.add("Developer");
	        professionList.add("Designer");
	        professionList.add("IT Manager");
	        model.put("professionList", professionList);
	         
	        return "login";
	  }
	@RequestMapping(method=RequestMethod.POST)
	 public String processRegistration(@ModelAttribute("userForm") User user,
			 Map<String, Object> model){
		 System.out.println("username: " + user.getUsername());
		 //Logic
		 
		 //TODO
		 return "registerSuccess";
	 }

}

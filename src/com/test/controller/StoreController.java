package com.test.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.AlbumDao;
import com.test.dao.GenreDao;
import com.test.dao.impl.GenreDaoImpl;
import com.test.model.Album;
import com.test.model.Genre;


@TransactionConfiguration(transactionManager = "jdbcTransactionManager", defaultRollback = true)


@Controller
public class StoreController {
     
	 @RequestMapping("/Store")
	    public ModelAndView Index() {
	  
	
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 GenreDao gd = ctx.getBean("genreDao", GenreDao.class);
		 List<Genre> genre = gd.genreIndex();
		 
	     return new ModelAndView("store", "message", genre);
	    }
	 
	  @RequestMapping("/Store/Browse")
	  public ModelAndView Browse(){
		  String message = "echo from store.browse";
		  System.out.println("this is user controller");
		  return new ModelAndView("store", "message", message);
	  }
	  @RequestMapping(value="/Store/Browse/{genreId}", method=RequestMethod.GET)
	  public ModelAndView findGenre(@PathVariable int genreId, Model model){
		  
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  AlbumDao ad = ctx.getBean("albumDao", AlbumDao.class);
		  List<Album> album= ad.SortByGenre(genreId);
		  
		  return new ModelAndView("store", "sort_by_genre", album);
		  //List<Map<String, Object>> albums = gd.genreBrowse(gd.genreId(genre));
		  //return new ModelAndView("store", "genreMsg", albums);
		  //return null;
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

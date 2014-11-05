package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.AlbumDao;
import com.test.dao.GenreDao;
import com.test.model.Album;

@Controller
public class StoreManagerController {

	 @RequestMapping("/StoreManager")
	    public ModelAndView Index() {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  AlbumDao ad = ctx.getBean("albumDao", AlbumDao.class);
		  List<Album> album= ad.albumIndex();
		  //System.out.println(album.);
		 GenreDao gd = ctx.getBean("genreDao", GenreDao.class);
		 for(int i =0; i<album.size();i++){
			 int id = album.get(i).getGenreId();
			 System.out.println(gd.genreBrowse(id));
		 }
		 
		 Map<String, Object> model = new HashMap<String, Object>();
		 model.put("albumList", album);
		 model.put("find_genre_by_id", gd);
		 String test ="this is in the test";
		 model.put("test", album.getClass().getSimpleName());
		 System.out.println(album);
		 return new ModelAndView("StoreManager/index","model",model);
	 }
}

package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.AlbumDao;
import com.test.dao.GenreDao;
import com.test.model.Album;

@Controller
public class StoreManagerController {

	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	AlbumDao ad = ctx.getBean("albumDao", AlbumDao.class);
	 
	Map<String, Object> model = new HashMap<String, Object>();
	 @RequestMapping("/StoreManager")
	    public ModelAndView Index() {
		 
		
		 List<Album> album= ad.albumIndex();
		
		 
		 model.put("albumList", album);
		
		 model.put("test", album.getClass().getSimpleName());
		
		 return new ModelAndView("StoreManager/index","model",model);
	 }
	 @RequestMapping("StoreManager/Edit/{albumId}")
	    public ModelAndView Edit(@PathVariable int albumId){
		
		Album albumEdit= ad.albumBrowse(albumId);
		
		model.put("albumEdit", albumEdit);
		 
		return new ModelAndView("StoreManager/edit","model",model);
	 }
	 
}

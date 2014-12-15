package com.test.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;




import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.AlbumDao;
import com.test.dao.ArtistDao;
import com.test.dao.GenreDao;
import com.test.model.Album;
import com.test.model.Genre;

@Controller
public class StoreManagerController {

	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	AlbumDao ad = ctx.getBean("albumDao", AlbumDao.class);
	GenreDao gd = ctx.getBean("genreDao", GenreDao.class); 
	ArtistDao artd = ctx.getBean("artistDao", ArtistDao.class); 
	
	
	Map<String, Object> model = new HashMap<String, Object>();
	 @RequestMapping("/StoreManager")
	    public ModelAndView Index() {
		 
		 List<Album> album= ad.albumIndex();
		 
		 model.put("albumList", album);
		 model.put("test", album.getClass().getSimpleName());
		
		 return new ModelAndView("StoreManager/index","model",model);
	 }
	 
	 @RequestMapping(value = "StoreManager/Create")
	    public ModelAndView Create(Model m){
		
		Map< Long, String > genreMap = new HashMap<Long, String>();
		List<Genre> genreList = gd.genreIndex();
		for(int i=0; i<genreList.size(); i++){
	      genreMap.put(genreList.get(i).genreId, genreList.get(i).name);
		}
		Map< Integer, String > artistMap = artd.artistIndex();
		model.put("genreMap", genreMap);
		model.put("artistMap", artistMap);
		
		m.addAttribute("command", new Album());
		return new ModelAndView("StoreManager/create","model",model);
	 
	 }
	 @RequestMapping(value = "StoreManager/Create", method=RequestMethod.POST)
	 public String createSubmmit(@Valid Album album, BindingResult result, Model m){
		 

		 System.out.println(result.hasErrors());
		 System.out.println(result.getErrorCount());
		 System.out.println(result.getFieldValue("artistId"));
		 System.out.println(result.getFieldValue("title").equals(""));
		 
		 m.addAttribute("artistId", album.getArtistId());
		 m.addAttribute("genreId", album.getGenreId());
		 m.addAttribute("title", album.getTitle());
		 m.addAttribute("price",album.getPrice());
		 m.addAttribute("albumArtUrl", album.getAlbumArtUrl());
		
		 //ad.albumCreate(album);
		 return "result";
	 }
	 
	 @RequestMapping(value = "StoreManager/Edit/{albumId}")
	    public ModelAndView Edit(@PathVariable int albumId, Model m){
		
		Album albumEdit= ad.albumBrowse(albumId);
	    List<Genre> genreList = gd.genreIndex();
	    Map< Integer, String > artistMap = artd.artistIndex();
	    
	    Map< Long, String > genreMap = new HashMap<Long, String>();

	    for(int i=0; i<genreList.size(); i++){
	  
	    	genreMap.put(genreList.get(i).genreId, genreList.get(i).name);
	    }
		model.put("albumEdit", albumEdit);
		model.put("genreMap", genreMap);
		model.put("artistMap",artistMap);
        System.out.println("id in the album EDIT"+albumEdit.getAlbumId());
	
	    m.addAttribute("command", new Album());
		return new ModelAndView("StoreManager/edit","model",model);
	 }
	 @RequestMapping(value = "StoreManager/editAlbum", method=RequestMethod.POST)
	 public String editAlbum(@ModelAttribute Album album, Model m){
		
		 m.addAttribute("price", album.getPrice());
		 m.addAttribute("genreId", album.getGenreId());
		 m.addAttribute("artistId", album.getArtistId());
		 m.addAttribute("title", album.getTitle());
		 m.addAttribute("price", album.getPrice());
		 m.addAttribute("albumArtUrl", album.getAlbumArtUrl());
		
		 ad.albumUpdate(album);
		 return "redirect:../StoreManager";
	 }

	 
	 @RequestMapping("StoreManager/Details/{albumId}")
	    public ModelAndView Detail(@PathVariable int albumId){
		
		Album albumEdit= ad.albumBrowse(albumId);
		
		model.put("albumEdit", albumEdit);
		 
		return new ModelAndView("StoreManager/details","model",model);
	 }
	 @RequestMapping("StoreManager/Delete/{albumId}")
	    public ModelAndView Delete(@PathVariable int albumId){
		
		Album albumEdit= ad.albumBrowse(albumId);
		
		model.put("albumEdit", albumEdit);
		 
		return new ModelAndView("StoreManager/delete","model",model);
	 }
	 @RequestMapping("StoreManager/Deleted/{albumId}")
	    public String Deleted(@PathVariable int albumId){
		
		ad.albumDelete(albumId);
		 
		return "redirect:../../StoreManager";
	 }

}

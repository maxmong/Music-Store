package com.test.model;

import java.util.List;

public class Genre {

	  public Long genreId;
	  public String name;
	  public String descrption;
	  //public List<Album> albums;
	  
	public Genre(){
		
	}
	public Genre(Long genreId, String name, String descrption) {
		super();
		this.genreId = genreId;
		this.name = name;
		this.descrption = descrption;
		//this.albums = albums;
	}
	public Long getGenreId() {
		return genreId;
	}
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
//	public List<Album> getAlbums() {
//		return albums;
//	}
//	public void setAlbums(List<Album> albums) {
//		this.albums = albums;
//	}
	  
	  
}

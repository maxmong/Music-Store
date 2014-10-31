package com.test.dao;

import java.util.List;

import com.test.model.Album;


public interface AlbumDao {
	public List<Album> albumIndex();
	public List<Album> albumBrowse(int albumId);
	public void albumCreate(Album album);
	public void albumUpdate(Album album);
	public void albumDelete(Long albumId);
	
	public List<Album> SortByGenre(int id);
}

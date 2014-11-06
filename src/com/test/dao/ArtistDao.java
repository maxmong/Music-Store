package com.test.dao;

import java.util.List;

import com.test.model.Artist;

public interface ArtistDao {

	public List<Artist> artistIndex();
	public Artist artistBrowse(int artistId);
	
	public List<Artist> SortByArtist(int artistId);
}

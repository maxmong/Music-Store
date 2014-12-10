package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.model.Artist;

public interface ArtistDao {

	public  Map< Integer, String > artistIndex();
	public Artist artistBrowse(int artistId);
	
	public List<Artist> SortByArtist(int artistId);
}

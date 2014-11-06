package com.test.dao;



import java.util.List;
import com.test.model.Genre;

public interface GenreDao {


	public List<Genre> genreIndex();
	public Genre genreBrowse(int genreId);
	public void genreCreate(Genre genre);
	public void genreUpdate(Genre genre);
	public void genreDelete(Long genreId);
}

package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.test.dao.AlbumDao;
import com.test.model.Album;

public class AlbumDaoImpl implements AlbumDao {

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private static final String SORT_BY_GENRE = "SELECT title FROM ALBUM WHERE genreId = ?";
	@Override
	public List<Album> albumIndex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> albumBrowse(int albumId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void albumCreate(Album album) {
		// TODO Auto-generated method stub

	}

	@Override
	public void albumUpdate(Album album) {
		// TODO Auto-generated method stub

	}

	@Override
	public void albumDelete(Long albumId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Album> SortByGenre(int id) {
		//HERE USE JDBCTEMPLATE
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Album> albumList = new ArrayList<Album>();
        
		List<Map<String,Object>> albumRows = jdbcTemplate.queryForList(SORT_BY_GENRE, id);
		for(Map<String,Object> albumRow : albumRows){
			Album alb = new Album();
			alb.setTitle(String.valueOf(albumRow.get("title")));
			albumList.add(alb);
		}
				
		return albumList;
	}

}

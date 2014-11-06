package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.dao.ArtistDao;
import com.test.model.Album;
import com.test.model.Artist;

public class ArtistDaoImpl implements ArtistDao {

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private static final String GET_ONE_BY_ID = "SELECT * FROM ARTIST WHERE artistId = ?";
	@Override
	public List<Artist> artistIndex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist artistBrowse(int artistId) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Artist alb = new Artist();
		
		List<Map<String,Object>> artistRows = jdbcTemplate.queryForList(GET_ONE_BY_ID, artistId);
		
		for(Map<String,Object> artistRow : artistRows){
		
			alb.setName(String.valueOf(artistRow.get("name")));
			
			
		}
		return alb;
		
	}

	@Override
	public List<Artist> SortByArtist(int artistId) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.test.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.dao.AlbumDao;
import com.test.dao.ArtistDao;
import com.test.dao.GenreDao;
import com.test.model.Album;
import com.test.model.Genre;

public class AlbumDaoImpl implements AlbumDao {

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private static final String BROWSE_ALBUM_BY_ID = "SELECT genreId, artistId, title, price, albumArtUrl FROM ALBUM WHERE albumId = ?";
	private static final String SORT_BY_GENRE = "SELECT title, albumId FROM ALBUM WHERE genreId = ?";
	private static final String ALBUM_INDEX = "SELECT albumId, genreId, artistId, title, price, albumArtUrl FROM ALBUM";
	

	
	@Override
	public List<Album> albumIndex() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Album> albumList = new ArrayList<Album>();
		
		List<Map<String,Object>> albumRows = jdbcTemplate.queryForList(ALBUM_INDEX);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		GenreDao gd = ctx.getBean("genreDao", GenreDao.class);
		ArtistDao ad = ctx.getBean("artistDao", ArtistDao.class);
		
		for(Map<String,Object> albumRow : albumRows){
			Album alb = new Album();
			//alb.setAlbumId((Integer) albumRow.get("albumId"));
			int albumId = Integer.parseInt(albumRow.get("albumId").toString());
			int genreId = Integer.parseInt(albumRow.get("genreId").toString());
			int artistId = Integer.parseInt(albumRow.get("artistId").toString());
			String title = albumRow.get("title").toString();
			BigDecimal price = (BigDecimal) albumRow.get("price");
		
			alb.setAlbumId(albumId);
			alb.setGenreId(genreId);
			alb.setArtistId(artistId);
			alb.setPrice(price);
		    alb.setTitle(title);
		    alb.setArtist(ad.artistBrowse(artistId));;
		    
			Genre genreList = new Genre();
			genreList = gd.genreBrowse(genreId);
			
			alb.setGenre(genreList);

			albumList.add(alb);
		}
		return albumList;
	}

	@Override
	public Album albumBrowse(int albumId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//List<Album> albumList = new ArrayList<Album>();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		GenreDao gd = ctx.getBean("genreDao", GenreDao.class);
		ArtistDao ad = ctx.getBean("artistDao", ArtistDao.class);
		
		
		
		
		List<Map<String,Object>> albumRows = jdbcTemplate.queryForList(BROWSE_ALBUM_BY_ID, albumId);
		Album alb = new Album();
		for(Map<String,Object> albumRow : albumRows){
			int artistId = Integer.parseInt(albumRow.get("artistId").toString());
			int genreId = Integer.parseInt(albumRow.get("genreId").toString());
			
			alb.setAlbumId(albumId);
			alb.setTitle(String.valueOf(albumRow.get("title")));
			alb.setGenreId(genreId);
			alb.setGenre(gd.genreBrowse(genreId));
			
			alb.setArtistId(Integer.parseInt(albumRow.get("artistId").toString()));
			alb.setPrice((BigDecimal) albumRow.get("price"));
			alb.setAlbumArtUrl(albumRow.get("albumArtUrl").toString());
			
			alb.setArtist(ad.artistBrowse(artistId));
			
			alb.setArtistId(Integer.parseInt(albumRow.get("artistId").toString()));
			//albumList.add(alb);
		}
		return alb;
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
			
			//alb.setAlbumId(Integer.parseInt((String) albumRow.get("albumId")));
			//System.out.println(albumRow.get("albumId").getClass().getSimpleName());
			int test = Integer.parseInt(albumRow.get("albumId").toString());
			
			
			alb.setAlbumId(test);
			albumList.add(alb);
		}
				
		return albumList;
	}

}

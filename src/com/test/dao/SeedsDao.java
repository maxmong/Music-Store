package com.test.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class SeedsDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    public String addSeeds(){
		
		//USE APACHE BATIS FOR albumSeeds 
		Connection con = null;
    	try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ScriptRunner sr = new ScriptRunner(con);
    	Reader album_reader;
    	Reader genre_reader;
    	Reader artist_reader;
		try {
			album_reader = new BufferedReader(new FileReader("C:/Users/01438407/git/Music-Store/resourses/albumSeeds.sql"));
			genre_reader = new BufferedReader(new FileReader("C:/Users/01438407/git/Music-Store/resourses/genreSeeds.sql"));
			artist_reader = new BufferedReader(new FileReader("C:/Users/01438407/git/Music-Store/resourses/artistSeeds.sql"));
			//InputStreamReader id = new InputStreamReader(null);
			sr.runScript(album_reader);
			sr.runScript(genre_reader);
			sr.runScript(artist_reader);
		
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		//counts
		int rowCount_album = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ALBUM");
		int rowCount_genre = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM GENRE");
		int rowCount_artist = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ARTIST");
		return "INSERT INTO GENRE " + rowCount_genre + " items<br> INSERT INTO ALBUM " + rowCount_album + " items<br> INSERT INTO ARTIST "+rowCount_artist+" items";

	}
    
    public void resetSeeds(){
    	String sql_genre = "DROP TABLE GENRE";
    	String sql_album = "DROP TABLE ALBUM";
    	String sql_artist = "DROP TABLE ARTIST";
    	this.jdbcTemplate.execute(sql_genre);
    	this.jdbcTemplate.execute(sql_album);
    	this.jdbcTemplate.execute(sql_artist);
    	
    }
}

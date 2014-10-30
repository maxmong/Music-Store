package com.test.dao;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class GenreDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Map<String, Object>>genreIndex(){
		
		String sql = "SELECT name FROM genre";
		List<Map<String,Object>> results = this.jdbcTemplate.queryForList(sql);
		
		//int rowCount = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ADDRESS");
		return results;	
	}
	public List<Map<String, Object>> genreBrowse(int genreId){
		//##TODO
		String sql = "SELECT title FROM ALBUM WHERE genreId = "+genreId;
		List<Map<String,Object>> results = this.jdbcTemplate.queryForList(sql);
		return results;	
	}
	public int genreId(final String genre){
		String sql = " = \"genre\"";
		int g_id = this.jdbcTemplate.queryForInt("SELECT genreid from GENRE WHERE name =");
		return g_id;
	}
}

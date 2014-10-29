package com.test.dao;



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
}

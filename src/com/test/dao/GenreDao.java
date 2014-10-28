package com.test.dao;



import org.springframework.jdbc.core.JdbcTemplate;

public class GenreDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int genreIndex(){
		
		//String sql = "SELECT description from w_basket";
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from w_basket", Integer.class);
		return rowCount;
		
	}
}

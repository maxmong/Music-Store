package com.test.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import com.test.dao.GenreDao;
import com.test.model.Genre;
import com.test.orm.GenreRowMapper;

public class GenreDaoImpl implements GenreDao {
	
	private static final String GET_ALL_SQL = "SELECT genreId, name, description FROM GENRE";
    
	public NamedParameterJdbcOperations jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private GenreRowMapper genreRowMapper;
	@Override
	public List<Genre> genreIndex() {
		
		return jdbcTemplate.query(GET_ALL_SQL, new HashMap<String, Object>(), genreRowMapper);
	}

	@Override
	public List<Genre> genreBrowse(int genreId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void genreCreate(Genre genre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void genreUpdate(Genre genre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void genreDelete(Long genreId) {
		// TODO Auto-generated method stub

	}

}

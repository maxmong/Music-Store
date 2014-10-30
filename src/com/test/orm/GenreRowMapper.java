package com.test.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.model.Genre;

public class GenreRowMapper implements RowMapper<Genre> {

	@Override
	public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {

        
		return new Genre(rs.getLong("genreId"),
				         rs.getString("name"),
				         rs.getString("description"));
	}

}

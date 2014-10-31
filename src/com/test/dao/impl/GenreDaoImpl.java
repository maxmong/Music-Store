package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.test.dao.GenreDao;
import com.test.model.Genre;

public class GenreDaoImpl implements GenreDao {
	
	private static final String GET_ALL_SQL = "SELECT genreId, name, description FROM GENRE";
    
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Genre> genreIndex() {
		List<Genre> genreAll = new ArrayList<Genre>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
		con = dataSource.getConnection();
		ps = con.prepareStatement(GET_ALL_SQL);
		rs = ps.executeQuery();
		
		while(rs.next()){
			Genre gen = new Genre(rs.getLong("genreId"), rs.getString("name"), rs.getString("description"));
			genreAll.add(gen);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return  genreAll;
	}

	@Override
	public List<Genre> genreBrowse(int genreId) {
		
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

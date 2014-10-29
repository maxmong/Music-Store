package com.test.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class SeedsDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    public int addSeeds(){
		
		String sql = "CREATE TABLE GENRE( "
				+ "genreId    NUMBER       NOT NULL  ,"
				+ " name     CHAR(20)      NOT NULL  ,"
				+ " description       CHAR(30)         NULL  ,"
				+ "CONSTRAINT PK_GENRE PRIMARY KEY (genreId)"
				+ ")";
		this.jdbcTemplate.execute(sql);
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(1,'Jazz','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(2,'Blues','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(4,'Rock','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(5,'Metal','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(6,'Alternative','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(7,'Disco','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(8,'Latin','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(9,'Reggae','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(10,'POP','LOUKE STRT')");
		this.jdbcTemplate.execute("INSERT INTO GENRE(genreId, name, description) VALUES(11,'Classical','LOUKE STRT')");
		
		int rowCount = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM GENRE");
		return rowCount;	
	}
    
    public void resetSeeds(){
    	String sql = "DROP TABLE GENRE";
    	this.jdbcTemplate.execute(sql);
    	
    }
}

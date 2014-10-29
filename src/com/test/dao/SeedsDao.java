package com.test.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class SeedsDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    public String addSeeds(){
		
		String sql_genre = "CREATE TABLE GENRE( "
				+ "genreId    NUMBER       NOT NULL  ,"
				+ " name     CHAR(20)      NOT NULL  ,"
				+ " description       CHAR(30)         NULL  ,"
				+ "CONSTRAINT PK_GENRE PRIMARY KEY (genreId)"
				+ ")";
		this.jdbcTemplate.execute(sql_genre);
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
		
		String sql_album = "CREATE TABLE ALBUM(albumId NUMBER NOT NULL, "
				+ "genreId NUMBER, "
				+ "artistId NUMBER, "
				+ "title CHAR(50), "
				+ "price NUMBER(4,2),"
				+ "albumArtUrl CHAR(50),"
				+ "CONSTRAINT PK_ALBUM PRIMARY KEY (albumId))";
		this.jdbcTemplate.execute(sql_album);
		this.jdbcTemplate.execute("INSERT INTO ALBUM(albumId, genreId, artistId, title, price, albumArtUrl) "
				+ "VALUES(1, 4, 1, 'The Best Of Men At Work', 8.99, '/Content/Images/placeholder.gif')");
		int rowCount_genre = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM GENRE");
		int rowCount_album = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ALBUM");
		return "INSERT INTO GENRE " + rowCount_genre + " INSERT INTO ALBUM " + rowCount_album;	
	}
    
    public void resetSeeds(){
    	String sql_genre = "DROP TABLE GENRE";
    	String sql_album = "DROP TABLE ALBUM";
    	this.jdbcTemplate.execute(sql_genre);
    	this.jdbcTemplate.execute(sql_album);
    	
    }
}

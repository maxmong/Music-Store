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
		
    	
    
		//String workingdirectory = System.getProperty("user.dir");
		//System.out.println(workingdirectory);
    	
		String sql_genre = "CREATE TABLE GENRE( "
				+ "genreId    NUMBER       NOT NULL  ,"
				+ " name     CHAR(60)      NOT NULL  ,"
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
		//table artist
		
		String sql_artist = "CREATE TABLE ARTIST(artistId NUMBER NOT NULL, "
				+ "name CHAR(90), "
				+ "CONSTRAINT PK_ARTIST PRIMARY KEY (artistId))";
		this.jdbcTemplate.execute(sql_artist);
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(1, 'Aaron Copland & London Symphony Orchestra')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(2, 'Aaron Goldberg')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(3, 'AC/DC')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(4, 'Accept')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(5, 'Adrian Leaper & Doreen de Feis')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(6, 'Aerosmith')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(7, 'Aisha Duo')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(8, 'Alanis Morissette')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(9, 'Alberto Turco & Nova Schola Gregoriana')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(10, 'Alice In Chains')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(11, 'Amy Winehouse')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(12, 'Anita Ward')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(13, 'Antônio Carlos Jobim')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(14, 'Apocalyptica')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(15, 'Audioslave')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(16, 'Barry Wordsworth & BBC Concert Orchestra')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(17, 'Berliner Philharmoniker & Hans Rosbaud')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(18, 'Berliner Philharmoniker & Herbert Von Karajan')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(19, 'Billy Cobham')");
		this.jdbcTemplate.execute("INSERT INTO ARTIST(artistId, name) "
				+ "VALUES(20, 'Black Label Society')");
		
		//table album
//		String sql_album = "CREATE TABLE ALBUM(albumId NUMBER NOT NULL, "
//				+ "genreId NUMBER, "
//				+ "artistId NUMBER, "
//				+ "title CHAR(90), "
//				+ "price NUMBER(4,2),"
//				+ "albumArtUrl CHAR(50),"
//				+ "CONSTRAINT PK_ALBUM PRIMARY KEY (albumId))";
//		this.jdbcTemplate.execute(sql_album);
//		this.jdbcTemplate.execute("INSERT INTO ALBUM(albumId, genreId, artistId, title, price, albumArtUrl) "
//				+ "VALUES(1, 4, 1, 'The Best Of Men At Work', 8.99, '/Content/Images/placeholder.gif')");
//		this.jdbcTemplate.execute("INSERT INTO ALBUM(albumId, genreId, artistId, title, price, albumArtUrl) "
//				+ "VALUES(2, 5, 2, 'Worlds', 8.99, '/Content/Images/placeholder.gif')");
//		int rowCount_genre = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM GENRE");
		
		//USE APACHE BATIS FOR TEST 
		Connection con = null;
    	try {
			con = jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ScriptRunner sr = new ScriptRunner(con);
    	Reader reader;
		try {
			reader = new BufferedReader(new FileReader("C:/Users/Yien/Documents/GitHub/Music-Store/resourses/test.sql"));
			
			//InputStreamReader id = new InputStreamReader(null);
			sr.runScript(reader);
		
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		//counts
		int rowCount_album = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ALBUM");
		int rowCount_artist = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ARTIST");
		return "INSERT INTO GENRE " + " items<br> INSERT INTO ALBUM " + rowCount_album + " items<br> INSERT INTO ARTIST "+rowCount_artist+" items";
		
		
	
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

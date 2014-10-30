package com.test.dao;



import java.util.List;
import com.test.model.Genre;

public interface GenreDao {

	//private JdbcTemplate jdbcTemplate;

	//public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	//	this.jdbcTemplate = jdbcTemplate;
	//}
	
	public List<Genre> genreIndex();
		
		//String sql = "SELECT name FROM genre";
		//List<Map<String,Object>> results = this.jdbcTemplate.queryForList(sql);
		
		//int rowCount = this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ADDRESS");
		//return results;	
	//}
	public List<Genre> genreBrowse(int genreId);
		//##TODO
		//String sql = "SELECT title FROM ALBUM WHERE genreId = "+genreId;
		//List<Map<String,Object>> results = this.jdbcTemplate.queryForList(sql);
		//return results;	
	//}
	//public int genreId(final String genre){
	//	String sql = " = \"genre\"";
	//	int g_id = this.jdbcTemplate.queryForInt("SELECT genreid from GENRE WHERE name =");
	//	return g_id;
	//}
	public void genreCreate(Genre genre);
	public void genreUpdate(Genre genre);
	public void genreDelete(Long genreId);
}

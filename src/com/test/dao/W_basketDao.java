package com.test.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.model.W_basket;

public class W_basketDao {

	  private JdbcTemplate jdbcTemplate;
	  
	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		    this.jdbcTemplate = jdbcTemplate;  
		}  
	  
	  public int saveBasket(W_basket b){
		  
		  String sql = "INSERT INTO w_basket(id, type, description) VALUES("
		  		+ b.getId() + ","
		  		+ b.getType() + ","
		  		+ "'" + b.getDescription() + "'"
		  		+ ")";
		  return jdbcTemplate.update(sql);
	  }
}

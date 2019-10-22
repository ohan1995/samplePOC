package com.springPOC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDAOImpl implements LoginDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LoginDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@SuppressWarnings("rawtypes")
	public int checkLogin(String email, String password) {
		//System.out.println(email + " " + password);
		
		//query for getting record from customer table using email and password
		String query = "select * from customer where (email= '"+ email + "' and password='" + password +"')";
		
		List results = jdbcTemplate.queryForList(query);
		
		System.out.println(results);
		
		// if size of list is greater than 0 then returning 1 --'INDICATES success'
		if(results.size() > 0) {
			return 1;
		}
		
		//failure
		return 0;
	}

}

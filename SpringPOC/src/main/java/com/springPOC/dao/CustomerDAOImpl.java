package com.springPOC.dao;

import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.springPOC.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveCustomer(Customer customer) {
		
			// insert query
			String sql = "INSERT INTO customer (id,username, email, password, mobile,gender ,dob,address, language, city)"
						+ " VALUES (?, ?, ?, ?, ? ,?,?,?,?,?)";
			
			//executing insert query using JdbcTemplate object
			jdbcTemplate.update(sql, customer.getId(), customer.getUsername(), customer.getEmail(), customer.getPassword(), customer.getMobile(),
								customer.getGender(),customer.getDob(), customer.getAddress(),customer.getLanguage(),customer.getCity());
			
		
	}

	@SuppressWarnings("rawtypes")
	public int getEmail(String email) {
		
		System.out.println(email);
		
		// query for getting all the email ids from DB
		String query = "SELECT email FROM customer"; 
		
		//executing query
        List results = jdbcTemplate.queryForList(query);
        
        for (Object result : results) {
            HashMap map = (HashMap) result;
            
            for (Object key : map.keySet()) {
                System.out.print(key + " = " + map.get(key) + "; ");
                
                // if any email is equal to the entered email from DB then it will return 1 else 0
                if(email.equals(map.get(key))){
                	return 1;
                }
            }
            System.out.println();
        }
		return 0;
	}
}

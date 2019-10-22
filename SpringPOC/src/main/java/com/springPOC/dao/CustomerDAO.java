package com.springPOC.dao;

import com.springPOC.model.Customer;

public interface CustomerDAO {
	
	//function for saving customer record
	public void saveCustomer(Customer customer);
	
	//function for validating email if already exists or not
	public int getEmail(String email);
}

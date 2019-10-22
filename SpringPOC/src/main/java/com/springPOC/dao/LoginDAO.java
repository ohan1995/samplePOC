package com.springPOC.dao;

public interface LoginDAO {
	
	//function to validate customer login
	public int checkLogin(String email, String password);
}

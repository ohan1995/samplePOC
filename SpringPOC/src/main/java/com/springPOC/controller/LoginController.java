package com.springPOC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springPOC.dao.LoginDAO;

@Controller
public class LoginController {
	
	@Autowired
	LoginDAO loginDAO;
	
	/*
	 * @param email
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String checkLogin(String email, String password) {
		
		//checkLogin method return 0 for failure and 1 for success
		int response = loginDAO.checkLogin(email, password);
		
		if(response == 1) {
			return "success";
		}else {
			return " ";
		}
	}
}

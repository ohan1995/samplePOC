package com.springPOC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springPOC.dao.CustomerDAO;
import com.springPOC.model.Customer;

@Controller
public class CustomerController {
		
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView newCustomer(ModelAndView model) {
		Customer newCustomer = new Customer();
		model.addObject("customer", newCustomer);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
		customerDAO.saveCustomer(customer);		
		return new ModelAndView("redirect:/success");
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success() {
		return "Register";
	}
	
	@ResponseBody
	@RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
	public String getEmail(String email) {
		int response = customerDAO.getEmail(email);
		System.out.println(response);
		if(response == 0)
			return "Ok";
		else
			return " ";
	}
	
}

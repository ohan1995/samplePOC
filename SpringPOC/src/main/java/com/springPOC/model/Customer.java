package com.springPOC.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//using lambok for setter and getter
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	
	private int id;
	private String username;
	private String email;
	private String password;
	private long mobile;
	private Date dob;
	private String address;
	private String gender;
	private String language;
	private String city;

}

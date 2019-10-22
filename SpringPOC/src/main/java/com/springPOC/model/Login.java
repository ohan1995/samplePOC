package com.springPOC.model;

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
public class Login {
	
	private String email;
	private String password;
	
}
